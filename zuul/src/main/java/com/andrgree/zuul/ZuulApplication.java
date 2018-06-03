package com.andrgree.zuul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@EnableSwagger2
public class ZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}

	@Autowired
	ZuulProperties properties;

	@Primary
	@Bean
	public SwaggerResourcesProvider swaggerResourcesProvider() {

		return () -> {
			List resources = new ArrayList<>();
			properties.getRoutes().values().stream()
					.forEach(route -> resources.add(createResource(route.getServiceId(), route.getId(), "2.0")));
			return resources;

		};

	}

	private SwaggerResource createResource(String name, String location, String version) {
		SwaggerResource swaggerResource = new SwaggerResource();
		swaggerResource.setName(name);
		swaggerResource.setLocation("/" + location + "/v2/api-docs");
		swaggerResource.setSwaggerVersion(version);

		return swaggerResource;

	}
}
