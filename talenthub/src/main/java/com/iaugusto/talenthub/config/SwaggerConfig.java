package com.iaugusto.talenthub.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Gestão de Vagas Talenthub")
                        .version("1.1.1")
                        .description("API para gestão de vagas de emprego")
                );
    }
}
