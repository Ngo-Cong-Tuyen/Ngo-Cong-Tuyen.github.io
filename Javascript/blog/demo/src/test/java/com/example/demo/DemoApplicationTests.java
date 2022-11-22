package com.example.demo;

//import com.example.demo.entity.Account;
import com.example.demo.entity.Email;
import com.example.demo.entity.User;
import com.example.demo.entity.UserId;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
		UserId userId = new UserId();
		userId.setName("Ngo");
		userId.setLastName("Cong Tuyen");

		Email email = Email.builder()
				.id(1)
				.name("tuyen")
				.domain("@gmail.com")
				.build();

		User user = new User(userId, email);
//		Account account = new Account(1,"public", user);
		System.out.println(user);
	}

}
