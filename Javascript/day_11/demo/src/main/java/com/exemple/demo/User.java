package com.exemple.demo;

import lombok.*;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
@Component
public class User {
    private int id;
    private String name;
    public void say() {
        System.out.println("say hello");
    }
}
