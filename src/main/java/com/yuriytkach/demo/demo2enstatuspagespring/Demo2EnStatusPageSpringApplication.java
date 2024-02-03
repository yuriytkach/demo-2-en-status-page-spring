package com.yuriytkach.demo.demo2enstatuspagespring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class Demo2EnStatusPageSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(Demo2EnStatusPageSpringApplication.class, args);
	}

//	@Bean
//	public Function<String, String> uppercase() {
//		return value -> value.toUpperCase();
//	}
}
