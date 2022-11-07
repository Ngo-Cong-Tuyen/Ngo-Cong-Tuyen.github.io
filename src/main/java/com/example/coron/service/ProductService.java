package com.example.coron.service;

import com.example.coron.dto.ProductDto;
import com.example.coron.dto.ProductInfo;
import com.example.coron.dto.ReviewInfo;
import com.example.coron.entity.*;
import com.example.coron.exception.NotFoundException;
import com.example.coron.feedback.SimpleFeedback;
import com.example.coron.repository.*;
import com.example.coron.request.ProductCreateRequest;
import com.example.coron.request.ProductUpdateRequest;
import com.example.coron.request.ReviewRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ProductService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AmountRepository amountRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private CartRepository cartRepository;


    // Create product service
    public void create(ProductCreateRequest request) {
        // Todo: do tags
        ModelMapper modelMapper = new ModelMapper();
        List<Amount> amounts = request.getAmounts().stream().map(amount -> modelMapper.map(amount,Amount.class)).collect(Collectors.toList());
        Product product = Product.builder()
                .sku(request.getSku())
                .name(request.getName())
                .content(request.getContent())
                .description(request.getDescription())
                .price(request.getPrice())
                .categories(categoryRepository.getByIdIn(request.getCategories()))
                .build();

        productRepository.save(product);
        amounts.forEach(amount -> amount.setProduct(product));
        amountRepository.saveAll(amounts);
    }

    public void update(ProductUpdateRequest request, String sku) {
        Product product = findBySku(sku);
        product.setSku(request.getSku());
        product.setName(request.getName());
        product.setContent(request.getContent());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setCategories(categoryRepository.getByIdIn(request.getCategories()));
        productRepository.save(product);
        List<Amount> amountExists = amountRepository.findByProduct_Sku(sku);
        request.getAmounts().forEach(amountRequest -> {
            amountExists.forEach(amount -> {
                if (amountRequest.getSize().equals(amount.getSize()) && amountRequest.getColor().equalsIgnoreCase(amount.getColor())){
                    amount.setQuantity(amountRequest.getQuantity());
                    amountRepository.save(amount);
                } else {
                    Amount amount1 = Amount.builder()
                            .color(amountRequest.getColor())
                            .size(amountRequest.getSize())
                            .quantity(amountRequest.getQuantity())
                            .product(product).build();
                    amountRepository.save(amount1);
                }
            });
        });
    }

    // Get list products to render
    public Page<Product> getAllProduct(Integer pageNo, Integer pageSize, String sortDir) {
        Pageable paging = PageRequest.of(pageNo-1,pageSize, Sort.by(sortDir));
        Page<Product> page= productRepository.findAll(paging);
        return page;
    }
    public List<ProductDto> getAllHotProductDto() {
        List<Product> products= productRepository.findAll();
        return mapperProductToProductDto(products);
    }

    public List<ProductDto> mapperProductToProductDto(List<Product> products) {
        return products.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .sorted((a,b) -> b.getCreatedAt().compareTo(a.getCreatedAt()))
                .collect(Collectors.toList());
    }
    // Delete product
    public void delete(String sku) {
        productRepository.delete(findBySku(sku));
    }


    // Find product by sku
    public Product findBySku(String sku){
        Product product = productRepository.findBySku(sku).orElseThrow(()->{
                throw new NotFoundException("Not found product with sku="+sku);
        });
        return product;
    }
    // Get ProductDto by sku
    public ProductDto getProductDto(String sku) {
        Product product= productRepository.findBySku(sku).get();
        return modelMapper.map(product, ProductDto.class);
    }


    public Page<Product> getAllProductInfo(int pageNumber, String sortField, String sortDir, String category,String color, String keyword) {
        Sort sort = Sort.by(sortField);
        sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
        Pageable pageable = PageRequest.of(pageNumber -1, 9, sort);
        if (keyword!= null) {
            keyword = "%"+ keyword+ "%";
            return productRepository.getAllProductInfo(keyword,category,color,pageable);
        } else
        return productRepository.getAllProductInfo("%%",category,color, pageable);

    }

    public SimpleFeedback createReview(ReviewRequest request, String email) {
        SimpleFeedback feedback = new SimpleFeedback();
        Object[] userObject  = userService.findUserByEmail(email);
        SimpleFeedback findUserFeedback =(SimpleFeedback) userObject[0];
        if (!findUserFeedback.isValidate()) {
            return  findUserFeedback;
        }
        User user = (User) userObject[1];
        Optional<Product> product = productRepository.findBySku(request.getSku());
        if (product.isEmpty()){
            feedback.setValidate(false);
            feedback.setMessage("Not found product have sku: "+ request.getSku());
            return feedback;
        }
        Review review = Review.builder()
                .content(request.getContent())
                .rating(request.getRating())
                .product(product.get())
                .user(user).build();
        reviewRepository.save(review);

        return feedback;
    }

    public List<ReviewInfo> getALLReviewsBySku(String sku) {
        List<Review> reviews = reviewRepository.findByProduct_Sku(sku);
        List<ReviewInfo> reviewInfos = new ArrayList<>();
        reviews.forEach(review -> {
            LocalDateTime time;
            if (review.getUpdatedAt()!= null) {
                time= review.getUpdatedAt();
            } else  time = review.getCreatedAt();

            ReviewInfo reviewInfo = ReviewInfo.builder()
                    .content(review.getContent())
                    .rating(review.getRating())
                    .username(review.getUser().getName())
                    .time(DateTimeFormatter.ofPattern("dd-MM-yyyy").format(time)).build();
            reviewInfos.add(reviewInfo);
        });
        return reviewInfos;
    }


    public Boolean checkConditionReview(String sku, String email) {
        List<Cart> carts = cartRepository.findByUser_EmailAndAmount_Product_SkuAndStatus(email,sku,2);
        if (carts.isEmpty()){
            return false;
        }
        LocalDateTime present = LocalDateTime.now();
        for (Cart cart: carts){
            LocalDateTime deadLineTime = cart.getUpdatedAt().plusDays(3);
            if (present.isBefore(deadLineTime)){
                return true;
            }
        }
        return false;
    }

    public List<ProductInfo> getHotProducts() {
        return productRepository.getHotProductInfos();
    }
}
