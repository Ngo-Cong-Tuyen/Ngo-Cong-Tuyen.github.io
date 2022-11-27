package com.example.validate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CustomerDTO {

    @NotNull(message = "Please provide first Name")
    private String firstName;

    @NotNull(message = "Please provide last Name")
    private String lastName;

    @NotNull
    @Min(value = 18, message = "Age should be equal or more than 18")
    private int age;

    @Email(message = "Please provide valid email address")
    private String email;

}
