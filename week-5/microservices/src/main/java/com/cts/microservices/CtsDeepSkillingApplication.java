package com.cts.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CtsDeepSkillingApplication {
    public static void main(String[] args) {
        SpringApplication.run(CtsDeepSkillingApplication.class, args);
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("CTS Deep Skilling API")
                        .version("1.0")
                        .description("API Documentation for CTS Deep Skilling"));
    }
}