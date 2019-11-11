package com.fcgl.madrid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

//@EnableEurekaClient
@SpringBootApplication
@EnableElasticsearchRepositories
public class MadridApplication {

	public static void main(String[] args) {
		SpringApplication.run(MadridApplication.class, args);
	}

}

