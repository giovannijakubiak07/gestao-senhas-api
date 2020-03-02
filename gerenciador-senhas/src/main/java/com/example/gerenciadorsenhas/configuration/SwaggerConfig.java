package com.example.gerenciadorsenhas.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.regex;
//Classe utilizada para TESTAR as requisções da API, para verificar /swagger-ui.html
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.gerenciadorsenhas"))
                .paths(regex("/.*"))
                .build()
                .apiInfo(metaInfo());

    }
    private ApiInfo metaInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Passwords API",
                "API REST para gestão de senhas. ",
                "1.0",
                "Terms of Service",
                new Contact("Giovanni Jakubiak de Albuquerque",
                        "https://www.linkedin.com/in/giovanni-jakubiak-de-albuquerque-087abb61/",
                        "giovannijakubiak@hotmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
        );

        return apiInfo;

    }
}
