package com.example.coron.service;

import com.example.coron.dto.BlogDto;
import com.example.coron.dto.ProductDto;
import com.example.coron.entity.Amount;
import com.example.coron.entity.Blog;
import com.example.coron.entity.Product;
import com.example.coron.exception.NotFoundException;
import com.example.coron.repository.AmountRepository;
import com.example.coron.repository.CategoryRepository;
import com.example.coron.repository.ProductRepository;
import com.example.coron.repository.TagRepository;
import com.example.coron.request.ProductCreateRequest;
import com.example.coron.request.ProductUpdateRequest;
import org.apache.catalina.LifecycleState;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
        delete(sku);
        create(modelMapper.map(request,ProductCreateRequest.class));
    }

    // Get list products to render
    public List<ProductDto> getAllProductDto() {
        List<Product> products= productRepository.findAll();
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


}
