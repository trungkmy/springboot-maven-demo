package com.act.techtalk2022;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class TechTalk2022Application {
    
	public static void main(String[] args) {
		SpringApplication.run(TechTalk2022Application.class, args);
	}
}
