package com.example.coron.controller;

import com.example.coron.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ImageController {
    @Autowired
    private ImageService imageService;


    // Upload images of the product
    @PostMapping("/products/{sku}/upload-image")
    public String uploadImageProduct(@PathVariable String sku, @ModelAttribute("file") MultipartFile file){
        return imageService.uploadImageProduct(sku, file);
    }

    // Get file with file name
    @GetMapping(value = "/products/{sku}/files/{fileId}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] readFile(@PathVariable String sku,@PathVariable String fileId){
        return imageService.readFile("products", sku, fileId);
    }

    // Get list file
    @GetMapping("/products/{sku}/files")
    public List<String> getFiles(@PathVariable String sku){
        return imageService.getFiles("products",sku);
    }


    //Delete images of the product.
    @DeleteMapping("/products/{sku}/files/{fileId}")
    public void deleteFile(@PathVariable String sku,@PathVariable String fileId){
        imageService.deleteFile("products", sku, fileId);
    }
}
