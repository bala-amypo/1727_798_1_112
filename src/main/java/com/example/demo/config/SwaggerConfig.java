package com.example.demo.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    public static final String SECURITY_SCHEME_NAME = "Bearer Authentication";

    @Bean
    public OpenAPI openAPI() {

        SecurityScheme bearerScheme = new SecurityScheme()
                .name("Authorization")
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT");

        return new OpenAPI()
                .info(new Info()
                        .title("Digital Credential Verification Engine")
                        .description("API Documentation")
                        .version("1.0"))

                // ✅ IMPORTANT: ONLY deployed server
                .servers(List.of(
                        new Server().url("https://9262.pro604cr.amypo.ai")
                ))

                .addSecurityItem(new SecurityRequirement()
                        .addList(SECURITY_SCHEME_NAME))

                .components(new Components()
                        .addSecuritySchemes(SECURITY_SCHEME_NAME, bearerScheme));
    }
}
