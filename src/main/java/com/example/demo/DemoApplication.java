package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;  // 追加
import org.springframework.web.bind.annotation.RestController;  // 追加

@SpringBootApplication
@RestController  // 追加
public class DemoApplication {
	// 追加
	@RequestMapping("/")
	public String home() {
		return "Hello World";
	}



	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}