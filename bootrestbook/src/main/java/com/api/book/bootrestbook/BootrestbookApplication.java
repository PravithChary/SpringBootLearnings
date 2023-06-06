package com.api.book.bootrestbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.api.book.bootrestbook")
public class BootrestbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootrestbookApplication.class, args);
	}

}
