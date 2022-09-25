package com.example.coron.service;

import com.example.coron.dto.ProductDto;
import com.example.coron.dto.ProductInfo;
import com.example.coron.entity.Amount;
import com.example.coron.entity.Product;
import com.example.coron.exception.NotFoundException;
import com.example.coron.repository.AmountRepository;
import com.example.coron.repository.CategoryRepository;
import com.example.coron.repository.ProductRepository;
import com.example.coron.repository.TagRepository;
import com.example.coron.request.ProductCreateRequest;
import com.example.coron.request.ProductUpdateRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
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
        ModelMapper modelMapper = new ModelMapper();
        List<Amount> amounts = request.getAmounts().stream().map(amount -> modelMapper.map(amount,Amount.class)).collect(Collectors.toList());
        productRepository.save(product);
        amountRepository.deleteByProduct(product);
        amounts.forEach(amount -> amount.setProduct(product));
        amountRepository.saveAll(amounts);
    }

    // Get list products to render
    public List<ProductDto> getAllProductDto() {
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


    public Page<Product> getAllProductInfo(int pageNumber, String sortField, String sortDir, String category, String keyword) {
        Sort sort = Sort.by(sortField);
        sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
        Pageable pageable = PageRequest.of(pageNumber -1, 9, sort);
        if (keyword!= null) {
            keyword = "%"+ keyword+ "%";
            return productRepository.getAllProductInfo(keyword,category,pageable);
        } else
        return productRepository.getAllProductInfo("%%",category, pageable);

    }


}
