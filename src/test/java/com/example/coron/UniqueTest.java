package com.example.coron;

import com.example.coron.dto.CartInfo;
import com.example.coron.dto.WishlistInfo;
import com.example.coron.entity.Product;
import com.example.coron.repository.CartRepository;
import com.example.coron.repository.ProductRepository;
import com.example.coron.repository.UserRepository;
import com.example.coron.repository.WishlistRepository;
import com.example.coron.service.*;
import com.example.coron.util.UtilsBackend;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

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
    @Autowired
    private UtilsBackend utilsBackend;
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private WishlistRepository wishlistRepository;
    @Autowired
    private ProductRepository productRepository;


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
        List<CartInfo> carts = cartService.getAllCartInfoByUserEmail("tuyen@gmail.com");
        carts.forEach(System.out::println);
    }

    @Test
    void filter() {
       Page<Product> page= productService.getAllProductInfo(1, "name", "asc","","", "vay");
       System.out.println(page.getTotalElements());
    }

    @Test
    void utilChangeStringToList() {
        System.out.println(utilsBackend.changeStringToList("16,15"));;
    }

    @Test
    void getOrders() {
        System.out.println(orderService.getAllOrder(1,9));
    }

    @Test
    void getAllUserDto() {
        System.out.println(userRepository.findAll());
        System.out.println(userService.getAllUserDto());
    }


    @Test
    void checkAddress() {
        Boolean check = userService.checkAddress("tuyenemotion@gmail.com");
        System.out.println(check);
    }

    @Test
    void findWishlist(){
        List<WishlistInfo> wishlistInfos = wishlistRepository.getWishListInfoByEmail("tuyenemotion@gmail.com");
        System.out.println(wishlistInfos);
    }

    @Test
    void findBySku() {
        Optional<Product> product = productRepository.findBySku("APN4396-TRA-S");
        System.out.println(product.get());
    }
}
