package com.example.RestDataJPA.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/**
 * Para entrar a la documentación de la Api Rest
 * http://localhost:8080/swagger-ui/
 */

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return  new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfoDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfoDetails(){
        return new ApiInfo("Spring Boot Laptop API Rest",
                "Education project",
                "1.0.0",
                "http://example.com",
                new Contact("Ezequiel Alonso", "example.com","example@gmail.com"),
                "MIT",
                "exampleLicense.com",
                Collections.emptyList());
    }

}
