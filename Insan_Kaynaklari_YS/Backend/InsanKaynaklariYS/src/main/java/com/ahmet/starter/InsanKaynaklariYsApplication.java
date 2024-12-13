package com.ahmet.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.ahmet"})              
@ComponentScan(basePackages = {"com.ahmet"})           
@EnableJpaRepositories(basePackages = {"com.ahmet"})   
public class InsanKaynaklariYsApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsanKaynaklariYsApplication.class, args);
	}

}
