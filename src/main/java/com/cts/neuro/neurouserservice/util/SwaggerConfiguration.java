package com.cts.neuro.neurouserservice.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
//@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket customAPI() {
        System.out.println("******** "+metaData().getTitle()+" "+metaData().getVersion()+" "+metaData().getContact()+" "+metaData().getContact().getEmail());
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(metaData()).select().apis(RequestHandlerSelectors.basePackage("com.cts.neuro")).paths(PathSelectors.any()).build();
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder().title("Neuro AI for QA - User Management API").version("1.0.0").contact(new Contact("Neuro AI QA Team", "https://www.cognizant.com/us/en/about-cognizant/contact-us", "john.doe@cognizant.com")).build();
    }
}
