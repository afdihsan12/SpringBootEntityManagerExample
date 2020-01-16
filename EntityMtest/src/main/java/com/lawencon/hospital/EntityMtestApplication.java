package com.lawencon.hospital;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com"})
@EnableTransactionManagement
@EntityScan(basePackages = "com")
@EnableJpaRepositories(basePackages  = {"com"})
public class EntityMtestApplication {

	public static void main(String[] args) {
		SpringApplication.run(EntityMtestApplication.class, args);
	}

}
