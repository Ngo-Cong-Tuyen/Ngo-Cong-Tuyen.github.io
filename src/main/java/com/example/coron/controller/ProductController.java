package com.example.coron.controller;

import com.example.coron.dto.ProductDto;
import com.example.coron.dto.ProductInfo;
import com.example.coron.entity.Product;
import com.example.coron.feedback.SimpleFeedback;
import com.example.coron.request.ProductCreateRequest;
import com.example.coron.request.ProductUpdateRequest;
import com.example.coron.request.ReviewRequest;
import com.example.coron.service.AuthService;
import com.example.coron.service.CategoryService;
import com.example.coron.service.ImageService;
import com.example.coron.service.ProductService;
import com.example.coron.util.UtilsBackend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class ProductController {


    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private AuthService authService;
    @Autowired
    private UtilsBackend utilsBackend;

    @GetMapping("/admin/products")
    public String getBlogsPage(Model model) {
        model.addAttribute("products", productService.getAllProductDto());
        System.out.println(productService.getAllProductDto());
        return "admin/product/product-index";
    }


    @GetMapping("/admin/products/create")
    public String getCreateBlogPage(Model model) {
        model.addAttribute("categories", categoryService.getAll());
        return "admin/product/product-create";
    }

    @GetMapping("/admin/products/{sku}")
    public String getDetailBlogsPage(@PathVariable String sku, Model model) {
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("product", productService.getProductDto(sku));
        model.addAttribute("images", imageService.getFiles("products",sku));
        return "admin/product/product-detail";
    }

    @PostMapping("/api/admin/products/create")
    @ResponseBody
    public void createProduct(@RequestBody ProductCreateRequest request){
        productService.create(request);
    }

    @PutMapping("/api/admin/products/{sku}")
    @ResponseBody
    public void updateProduct(@RequestBody ProductUpdateRequest request, @PathVariable String sku){
        productService.update(request, sku);
    }

    @DeleteMapping("/api/admin/products/{sku}")
    @ResponseBody
    public void deleteProduct(@PathVariable String sku){
        productService.delete(sku);
    }

    // pagination and sorting
    @RequestMapping("/shop")
    public String viewShopPage(Model model){
        String keyword = "";
        String category= "";
        return listByPage(model,1, "name", "asc",category, keyword);
    }

    @GetMapping("/shop/page/{pageNumber}")
    public String listByPage(Model model,
                             @PathVariable("pageNumber") int currentPage,
                             @RequestParam String sortField,
                             @RequestParam String sortDir,
                             @RequestParam(defaultValue = "") String category,
                             @RequestParam(defaultValue = "") String keyword){
        Page<Product> page = productService.getAllProductInfo(currentPage,sortField,sortDir,category, keyword);
        List<ProductDto> products = productService.mapperProductToProductDto(page.getContent());
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("products",products);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("totalPage", page.getTotalPages());
        model.addAttribute("keyword", keyword);
        model.addAttribute("categorySearch", category);
        model.addAttribute("parentCategories", categoryService.getAllParentCategory());
        model.addAttribute("categories", categoryService.getAll());
        return "web/shop";
    }

    @GetMapping("/single-product/{sku}")
    public String getSingleProductPage(@PathVariable String sku, Model model) {
        String email = authService.checkUser();
        model.addAttribute("product", productService.getProductDto(sku));
        model.addAttribute("reviews", productService.getALLReviewsBySku(sku));
        model.addAttribute("averageRating",utilsBackend.calculateAverageRating(productService.getALLReviewsBySku(sku)));
        model.addAttribute("signal", productService.checkConditionReview(sku, email));
        return "web/single-product";
    }
    @PostMapping("/api/v1/reviews/create")
    @ResponseBody
    public SimpleFeedback createReview(@RequestBody ReviewRequest request){
        String email = authService.checkUser();
        return productService.createReview(request, email);
    }
}
