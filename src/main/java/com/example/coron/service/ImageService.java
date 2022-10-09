package com.example.coron.service;

import com.example.coron.entity.Image;
import com.example.coron.entity.Product;
import com.example.coron.exception.NotFoundException;
import com.example.coron.repository.ImageRepository;
import com.example.coron.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ImageService {
    @Autowired
    private FileService fileService;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ImageRepository imageRepository;

    public String uploadFile(String object, String sku, MultipartFile file){
        if (productRepository.findBySku(sku).isEmpty()){
            throw new NotFoundException("Not found product with id = "+sku);
        }
        // upload file
        return fileService.uploadFile(object,sku,file);
    }

    // upload image file of product with product sku
    public String uploadImageProduct(String sku, MultipartFile file) {
        Product product = productRepository.findBySku(sku).orElseThrow(()->{
            throw new NotFoundException("Not found product with sku = "+sku);
        });

        String filePath =uploadFile("products",sku, file);
        Image image = Image.builder()
                .url(filePath)
                .product(product).build();
        imageRepository.save(image);
        return filePath;
    }

    // Read file
    public byte[] readFile(String object,String sku, String fileId){
        return fileService.readFile(object,sku, fileId);
    }
    public List<String> getFiles(String object, String sku) {
        return fileService.getFiles(object,sku);
    }

    // delete File
    public void deleteFile(String object, String sku, String fileId) {
        fileService.deleteFile(object,sku,fileId);
    }
}
