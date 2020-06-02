package com.umair.popularpennystocks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = { "com.umair" })
public class PopularPennyStocksApplication {

	public static void main(String[] args) {
		SpringApplication.run(PopularPennyStocksApplication.class, args);
	}

}
