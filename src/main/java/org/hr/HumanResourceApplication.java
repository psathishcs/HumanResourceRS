package org.hr;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class HumanResourceApplication {
	public static void main(String[] args){
		SpringApplication.run(HumanResourceApplication.class, args);
	}
	
	@Bean
	public AlwaysSampler defaultSampler() {
	  return new AlwaysSampler();
	} 

	@Bean
	public Docket api() {                
	    return new Docket(DocumentationType.SWAGGER_2)          
	      .select()
	      .apis(RequestHandlerSelectors.any())
	      .build()
	      .apiInfo(apiInfo());
	}
	 
	private ApiInfo apiInfo() {
	    ApiInfo apiInfo = new ApiInfo(
	      "HumanResourceRS",
	      "Human Resource RESTfull API",
	      "API TOS",
	      "Terms of service",
	      new Contact("Sathish Kumar Parthasarathy", "https://github.com/psathishcs", "p.sathish.cs@gmail.com"),
	      "License of API",
	      "API license URL");
	    return apiInfo;
	}
}
