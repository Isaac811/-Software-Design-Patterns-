package com.work.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class SwaggerOpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        Contact contact = new Contact()
                .name("Jiayu Liu")
                .email("Jiayu Liu1019@aliyun.com")

                ;

        Info info = new Info()
                .title("Shopinterface")
                .description("Shopapi")
                .version("1.2.1")
                .contact(contact);
        return new OpenAPI()
                .openapi("3.0.1")
                .info(info);
    }
}