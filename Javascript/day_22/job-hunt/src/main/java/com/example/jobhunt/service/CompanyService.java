package com.example.jobhunt.service;

import com.example.jobhunt.model.Company;
import com.example.jobhunt.repo.CompanyRepo;
import com.example.jobhunt.request.CreateCompanyRequest;
import com.example.jobhunt.request.UpdateCompanyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepo companyRepo;
    //Lay tat ca company
    public List<Company> getAll(){
       return companyRepo.findAll();
    }

    public Company getCompanyById(int id){
        return companyRepo.getById(id);
    }

    public void deleteCompany(int id) {
        companyRepo.deleteCompanyById(id);
    }

    public void createCompany(CreateCompanyRequest request) {
        companyRepo.createCompany(request);
    }

    public void updateCompany(int id, UpdateCompanyRequest request) {
        companyRepo.updateCompanyById(id, request);
    }
}
