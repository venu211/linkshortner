package com.api.linkshortner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LinkshortnerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinkshortnerApplication.class, args);
	}

}
