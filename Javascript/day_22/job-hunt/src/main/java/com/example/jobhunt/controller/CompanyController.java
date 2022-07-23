package com.example.jobhunt.controller;

import com.example.jobhunt.request.CreateCompanyRequest;
import com.example.jobhunt.request.UpdateCompanyRequest;
import com.example.jobhunt.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/companies")
    public String getCompanyListPage(Model model){
        model.addAttribute("companies", companyService.getAll());
        return "admin/company-list";
    }

    @GetMapping("/companies/{id}")
    public String getCompanyDetailPage(Model model, @PathVariable int id){
        model.addAttribute("company", companyService.getCompanyById(id));
        return "admin/company-edit";
    }

    @DeleteMapping("/api/admin/companies/{id}")
    public ResponseEntity<?> deleteCompany(@PathVariable int id) {
        companyService.deleteCompany(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/api/admin/companies")
    @ResponseBody
    public void createCompany(@RequestBody CreateCompanyRequest request) {
        companyService.createCompany(request);
    }

    @PutMapping("/api/admin/companies/{id}")
    @ResponseBody
    public void updateCompany(@PathVariable int id,@RequestBody UpdateCompanyRequest request) {
        companyService.updateCompany(id, request);
    }

    @GetMapping("/companies/create")
    public String getCompanyCreatePage(){
        return "admin/company-create";
    }

    @GetMapping("/companies/edit")
    public String getCompanyEditPage(){
        return "admin/company-edit";
    }
}
