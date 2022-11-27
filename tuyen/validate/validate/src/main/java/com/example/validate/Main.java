package com.example.validate;

import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Main {
    @GetMapping("/greeting")
    public Greeting sayHello(@RequestParam(value = "name") String name){
        return new Greeting(1, "Hello "+ name);
    }

    @PostMapping("/customer")
    public ResponseEntity<?> createCustomer(@Valid @RequestBody CustomerDTO customer){

        HttpHeaders responseHeader = new HttpHeaders();
        return new ResponseEntity<>(customer, responseHeader, HttpStatus.CREATED);
    }
}
