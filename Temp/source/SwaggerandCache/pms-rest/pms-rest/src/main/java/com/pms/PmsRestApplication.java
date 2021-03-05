package com.pms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableCaching
@EnableScheduling
@EnableSwagger2
public class PmsRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(PmsRestApplication.class, args);
	}
	
	@Bean
	public Docket  docket() {
		Docket d = new Docket(DocumentationType.SWAGGER_2);
		d.select().apis(RequestHandlerSelectors.basePackage("com.pms"))
		          .paths(PathSelectors.any())
		          .build()
		          .useDefaultResponseMessages(false);
		return d;
	
	}

}
