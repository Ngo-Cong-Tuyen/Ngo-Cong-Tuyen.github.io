package com.example.jobhunt.controller;

import com.example.jobhunt.request.UpdateJobRequest;
import com.example.jobhunt.service.CompanyService;
import com.example.jobhunt.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class JobController {

    @Autowired
    private JobService jobService;
    @Autowired
    private CompanyService companyService;


    @GetMapping("/admin/jobs")
    public String getJobListPage(Model model){
        model.addAttribute("jobs", jobService.getAll());
        return "admin/job-list";
    }

    @GetMapping("/admin/jobs/create")
    public  String getJobCreatePage(){
        return "admin/job-create";
    }

    @GetMapping("/admin/jobs/{id}")
    public  String getJobEditPage(Model model, @PathVariable int id){
        model.addAttribute("job", jobService.getJobById(id));
        model.addAttribute("companies", companyService.getAll());
        return "admin/job-edit";
    }

    @DeleteMapping("/api/admin/jobs/{id}")
    public ResponseEntity<?> deleteJobById(@PathVariable int id) {
        jobService.deleteJobById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/api/admin/jobs/{id}")
    @ResponseBody
    public void updateJobById(@PathVariable int id, @RequestBody UpdateJobRequest request){
        jobService.updateJobById(id, request);
    }

}
