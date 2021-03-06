package com.example.jobhunt.repo;

import com.example.jobhunt.exception.NotFoundException;
import com.example.jobhunt.model.Company;
import com.example.jobhunt.request.CreateCompanyRequest;
import com.example.jobhunt.request.UpdateCompanyRequest;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.IntStream;

@Repository
public class CompanyRepo  {
    // Tạo list companies để quản lý
    private List<Company> companies;

    // Trong constructor của class, gọi method initCompany() để khởi tạo các đối tượng và thêm vào list
    public CompanyRepo() {
        initCompany();
    }

    // Tạo danh sách company ban đầu
    public void initCompany() {
        Random rd = new Random();
        Faker faker = new Faker();

        companies = new ArrayList<>();

        // Danh sách 1 số thành phố
        List<String> cites = Arrays.asList("Thành phố Hà Nội", "Thành phố Đà Nẵng", "Thành phố Hồ Chí Minh");

        // Tạo 1 vài đối tượng company và thêm vào list
        IntStream.range(1, 5).forEach(n -> {
            Company company = new Company();
            company.setId(n);
            company.setName(faker.company().name());
            company.setLogoPath(faker.company().logo());
            company.setWebsite(faker.company().url());
            company.setEmail(faker.internet().emailAddress());
            company.setCity(cites.get(rd.nextInt(cites.size())));
            company.setDescription(faker.lorem().sentence(30));

            companies.add(company);
        });
    }
    // Lấy tất cả danh sách company
    public List<Company> findAll() {
        return companies;
    }

    // Lấy thông tin company theo id
    public Company getById(int id) {
        Optional<Company> optionalCompany = findById(id);
        if (optionalCompany.isPresent()) {
            return optionalCompany.get();
        }

        throw new NotFoundException("Không tìm thấy công ty có id = " + id);
    }

    // Lưu company
    public void save(Company company) {
        companies.add(company);
    }

    // Xóa company
    public void delete(int id) {
        Optional<Company> optionalCompany = findById(id);
        if (optionalCompany.isEmpty()) {
            throw new NotFoundException("Không tìm thấy công ty có id = " + id);
        }

        companies.removeIf(company -> company.getId() == id);
    }

    // HELPER method : Tìm kiếm company theo id
    public Optional<Company> findById(int id) {
        return companies.stream().filter(job -> job.getId() == id).findFirst();
    }

    public void deleteCompanyById(int id) {
        if (findById(id).isEmpty()) {
            throw new NotFoundException("Khong tim thay company co id= "+id);
        }
        companies.removeIf(company -> company.getId()==id);
    }

    public void createCompany(CreateCompanyRequest request) {
        Random rd = new Random();
        Company company = new Company();
        company.setId(rd.nextInt(100));
        company.setCity(request.getCity());
        company.setEmail(request.getEmail());
        company.setName(request.getName());
        company.setWebsite(request.getWebsite());
        company.setDescription(request.getDescription());
        companies.add(company);
    }

    public void updateCompanyById(int id, UpdateCompanyRequest request) {
        Company company = findById(id).orElseThrow(()->{
            throw new NotFoundException("Khong ton tai user co id = "+id);
        });
        company.setLogoPath(request.getLogoPath());
        company.setCity(request.getCity());
        company.setEmail(request.getEmail());
        company.setName(request.getName());
        company.setWebsite(request.getWebsite());
        company.setDescription(request.getDescription());
    }
}



