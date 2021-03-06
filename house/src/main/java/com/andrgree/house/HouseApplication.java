package com.andrgree.house;

import com.andrgree.house.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;


//@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
@EnableSwagger2
@EnableHystrix
public class HouseApplication implements CommandLineRunner {

	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(15_000L);
		SpringApplication.run(HouseApplication.class, args);
	}

	@Autowired
	private HouseService houseService;

	@Bean
	public Docket swaggerApi() {
		List<ResponseMessage> responseMessage = new ArrayList(){{
			add(new ResponseMessageBuilder()
				.code(500)
				.message("500 message")
				.responseModel(new ModelRef("Error"))
				.build());
			add(new ResponseMessageBuilder()
				.code(403)
				.message("Forbidden!")
				.build());
		}};
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.andrgree.house.controller"))
				//.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				//.paths(PathSelectors.ant("/foos/*"))
				.build()
				.apiInfo(new ApiInfoBuilder().version("1.0").title("House API").description("Documentation House API v1.0").build())
				/*.useDefaultResponseMessages(false)
				.globalResponseMessage(RequestMethod.GET, responseMessage)*/;

	}

	@Override
	public void run(String... args) throws Exception {
		houseService.createHouse(1L, "Grag", "Test");
	}
}
