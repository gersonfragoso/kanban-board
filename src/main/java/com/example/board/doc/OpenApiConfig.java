package com.example.board.doc;

import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Kanban board - Rest API")
                        .version("1.0")
                        .description("API que cria um kanban-board utilizando spring")
                        .contact(new io.swagger.v3.oas.models.info.Contact()
                                .name("Gerson Fragoso")
                                .url("https://www.linkedin.com/in/gerson-fragoso-424b4721b")
                                .email("gersonfragoso.araujo@gmail.com")));
    }
}
