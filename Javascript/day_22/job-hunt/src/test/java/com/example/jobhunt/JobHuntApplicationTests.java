package com.example.jobhunt;

import com.example.jobhunt.model.Company;
import com.example.jobhunt.model.Job;
import com.example.jobhunt.repo.CompanyRepo;
import com.example.jobhunt.repo.JobRepo;
import com.example.jobhunt.util.Utils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class JobHuntApplicationTests {

	@Autowired
	private CompanyRepo companyRepo;
	@Autowired
	private JobRepo jobRepo;

	@Test
	public void get_all_company(){
//		List<Company> companies = companyRepo.findAll();
//		companies.forEach(System.out::println);
//
//		Assertions.assertThat(companies).isNotNull();
//		Assertions.assertThat(companies.size()).isEqualTo(4);
//		List<Job> jobs = jobRepo.findAll();
//		jobs.forEach(System.out::println);

		System.out.println(	Utils.money(20000));
	}

}
