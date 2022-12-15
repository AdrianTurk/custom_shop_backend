package com.custom_shop;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomShopApplication.class, args);
	}

	@Bean
	public CommandLineRunner init() {
		System.out.println("hola");
		return (args) -> {
			System.out.println(args);
		};
	}
}
