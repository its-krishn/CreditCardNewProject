/**
 * Spring Boot CreditCardProject
 * Class Name : CreditCardProject1Application
 * Class Description : Application class for CreditCardProject Application
 * @author :vn51ore   
 * @version jdk : 1.8
 * 
 * Copyright Notice
 * 
 * Copyright (c) 2021 Walmart. All Right Reserved.
 * This software is the confidential and proprietary information of WalMart
 * You shall not disclose or use Confidential information without the express
 * written agreement of Walmart
 *
 **/
package com.training.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
//@EnableWebMvc
@ComponentScan

public class CreditCardProject1Application extends SpringBootServletInitializer { 

	@Override
	/*
	 * main() method is entry point of the program. JVM searches for main() method
	 */
	protected SpringApplicationBuilder configure(SpringApplicationBuilder app) {
		return app.sources(CreditCardProject1Application.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(CreditCardProject1Application.class, args);
	}

	/**
	 * @Bean public Docket api() { return new
	 *       Docket(DocumentationType.SWAGGER_2).select()
	 *       .apis(Predicates.not(RequestHandlerSelectors.basePackage("com.training.project"))).build();
	 * 
	 *       }
	 **/

}
