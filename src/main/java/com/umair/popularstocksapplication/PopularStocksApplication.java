package com.umair.popularstocksapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.umair"})
public class PopularStocksApplication {

	public static void main(String[] args) {
		SpringApplication.run(PopularStocksApplication.class, args);
	}

}
