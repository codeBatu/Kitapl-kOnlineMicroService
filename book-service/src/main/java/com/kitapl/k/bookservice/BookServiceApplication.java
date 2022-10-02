package com.kitapl.k.bookservice;

import com.kitapl.k.bookservice.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BookServiceApplication  {

	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}



}
