package com.example.coron;

import com.example.coron.entity.Product;
import com.example.coron.repository.CartRepository;
import com.example.coron.service.AuthService;
import com.example.coron.service.CartService;
import com.example.coron.service.FileService;
import com.example.coron.service.ProductService;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@SpringBootTest
public class UniqueTest {

    @Autowired
    private FileService fileService;
    @Autowired
    private AuthService authService;
    @Autowired
    private CartService cartService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Test
    void getDir() {
        Path productDir = Paths.get("uploads").resolve("sku");
    }

    @Test
    void getFiles() {
       List<String> files= fileService.getFiles("products","AT0001");
        System.out.println(files);
    }

    @Test
    void checkAccount() {
       Boolean check=  authService.checkAccount("tuyen@gmail.com","$2a$10$qed.yNl3Roi9jhaF09xaVenawXhNYwSy0xeXCaM0IfC7jjQm6AWwm");
        System.out.println(check);
    }

    @Test
    void getCart() {
        System.out.println(cartService.getAllCartInfoByUserEmail("tuyen@gmail.com"));
    }

    @Test
    void filter() {
       Page<Product> page= productService.getAllProductInfo(1, "name", "asc","", "vay");
       System.out.println(page.getTotalElements());
    }


}
