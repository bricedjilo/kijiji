package com.kijiji;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.Resource;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.kijiji")
public class App {
	public static void main(String[] args) {
		
		SpringApplication.run(App.class, args);
		
	}

}
