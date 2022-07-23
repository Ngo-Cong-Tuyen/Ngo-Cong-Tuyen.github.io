package com.example.jobhunt.service;

import com.example.jobhunt.dto.CompanyDto;
import com.example.jobhunt.dto.JobInfo;
import com.example.jobhunt.model.Company;
import com.example.jobhunt.model.Job;
import com.example.jobhunt.repo.CompanyRepo;
import com.example.jobhunt.repo.JobRepo;
import com.example.jobhunt.request.UpdateJobRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobService {
    @Autowired
    private CompanyRepo companyRepo;

    @Autowired
    private JobRepo jobRepo;

    // Lấy danh sách tất cả các job
// Kiểu trả về là JobInfo
    public List<JobInfo> getAll() {
        List<Job> jobs =  jobRepo.findAll();

        return jobs.stream().map(job -> {
            JobInfo jobInfo = new JobInfo();
            jobInfo.setId(job.getId());
            jobInfo.setTitle(job.getTitle());
            jobInfo.setDescription(job.getDescription());
            jobInfo.setSkills(job.getSkills());
            jobInfo.setSalary(job.getSalary());

            Company company = companyRepo.getById(job.getCompanyId());
            jobInfo.setCompanyDto(new CompanyDto(company.getId(), company.getName(), company.getLogoPath(), company.getCity(), company.getDescription()));

            return jobInfo;
        }).collect(Collectors.toList());
    }

    public JobInfo getJobById(int id) {
        Job job = jobRepo.getJobById(id);
        JobInfo jobInfo = new JobInfo();
        jobInfo.setId(job.getId());
        jobInfo.setTitle(job.getTitle());
        jobInfo.setDescription(job.getDescription());
        jobInfo.setSkills(job.getSkills());
        jobInfo.setSalary(job.getSalary());

        Company company = companyRepo.getById(job.getCompanyId());
        jobInfo.setCompanyDto(new CompanyDto(company.getId(), company.getName(), company.getLogoPath(), company.getCity(), company.getDescription()));
        return jobInfo;
    }

    public void deleteJobById(int id) {
        jobRepo.delete(id);
    }

    public void updateJobById(int id, UpdateJobRequest request) {
        jobRepo.updateJobById(id, request);
    }
}
