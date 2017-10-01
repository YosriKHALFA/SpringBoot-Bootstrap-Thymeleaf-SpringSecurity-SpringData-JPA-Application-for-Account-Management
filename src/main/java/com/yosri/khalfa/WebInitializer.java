package com.yosri.khalfa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages={"com.yosri.khalfa"})
public class WebInitializer extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(WebInitializer.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(WebInitializer.class, args);
	}
}
