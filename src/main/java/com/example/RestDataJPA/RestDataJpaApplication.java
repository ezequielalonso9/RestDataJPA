package com.example.RestDataJPA;

import com.example.RestDataJPA.entities.Laptop;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.RestDataJPA.repository.LaptopRepository;
@SpringBootApplication

public class RestDataJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(RestDataJpaApplication.class, args);
		LaptopRepository laptopRepository = context.getBean(LaptopRepository.class);

		Laptop laptop1 = new Laptop(null,"Asus","AAA",150000d);
		Laptop laptop2 = new Laptop(null,"Mac","XXX",500000d);

		laptopRepository.save(laptop1);
		laptopRepository.save(laptop2);

	}

}
