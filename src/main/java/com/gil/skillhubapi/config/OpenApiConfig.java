package com.gil.skillhubapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI().info( new Info().title( "Minha Api" )
                . version( "1.0" )
                .description( "API Spring Boot 3 com Swagger" ) );
    }
}
