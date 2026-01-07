package com.gil.skillhubapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    /*@Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI().info( new Info().title( "Skillhub Api" )
                . version( "1.0" )
                .description( "Marketplace de serviços" ) );
    }
    Mudaremos o OpenApi para atender as configurações de Segurança*/

    public static final String SECURITY_SCHEME_NAME = "BeareAuth";

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Skilhub API")
                        .version("1.0")
                        .description("Marketplace de Serviços"))
                .addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEME_NAME))
                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes(SECURITY_SCHEME_NAME,
                                new SecurityScheme()
                                        .name(SECURITY_SCHEME_NAME)
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                        ));
    }

}
