package com.example.demo.config;

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
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("Digital Credential Verification Engine")
                        .version("1.0"))
                
                // ✅ SERVER (CHANGE PORT HERE IF NEEDED)
                .servers(List.of(
                        new Server().url("http://localhost:9001"),
                        new Server().url("https://9262.pro604cr.amypo.ai")
                ))

                // ✅ APPLY JWT SECURITY GLOBALLY
                .addSecurityItem(new SecurityRequirement()
                        .addList(SECURITY_SCHEME_NAME))

                // ✅ DEFINE BEARER JWT SCHEME
                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes(
                                SECURITY_SCHEME_NAME,
                                new SecurityScheme()
                                        .name(SECURITY_SCHEME_NAME)
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                        ));
    }
}
