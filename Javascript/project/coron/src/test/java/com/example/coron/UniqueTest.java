package com.example.coron;

import com.example.coron.service.FileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@SpringBootTest
public class UniqueTest {

    @Autowired
    private FileService fileService;

    @Test
    void getDir() {
        Path productDir = Paths.get("uploads").resolve("sku");
    }

    @Test
    void getFiles() {
       List<String> files= fileService.getFiles("products","AT0001");
        System.out.println(files);
    }
}
