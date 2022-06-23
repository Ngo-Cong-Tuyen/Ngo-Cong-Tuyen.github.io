package com.exemple.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Random;

@SpringBootApplication
public class DemoApplication {
	@Bean
	public Random random() {
		return new Random();
	}

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		Random rd = context.getBean(Random.class);
		System.out.println(rd.nextInt(1000));

//		Student student = context.getBean(Student.class);
//		student.getVehicle().move();

		IVehicle vehicle = context.getBean("bus",IVehicle.class);
		vehicle.move();
	}
	
}
