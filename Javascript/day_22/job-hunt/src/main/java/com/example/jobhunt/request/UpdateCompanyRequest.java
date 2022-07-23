package com.example.jobhunt.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCompanyRequest {
    private String name; // tên công ty
    private String logoPath; // logo đại diện
    private String website; // địa chỉ website
    private String email; // email của công ty
    private String city; // địa chỉ công ty (thành phố)
    private String description; // Mô tả ngắn về công ty
}
