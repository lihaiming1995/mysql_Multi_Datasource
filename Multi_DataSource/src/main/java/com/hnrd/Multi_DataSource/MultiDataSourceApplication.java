package com.hnrd.Multi_DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class MultiDataSourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiDataSourceApplication.class, args);
	}

}

