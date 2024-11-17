package com.example.springboothelloworldidea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication//Spring Boot项目启动器注解
public class SpringBootHelloWorldIdeaApplication {

	@RequestMapping("/")
	public String index(){
		return "Hello, Spring Boot!";
	}

	public static void main(String[] args) {

		SpringApplication.run(SpringBootHelloWorldIdeaApplication.class, args);
	}

}