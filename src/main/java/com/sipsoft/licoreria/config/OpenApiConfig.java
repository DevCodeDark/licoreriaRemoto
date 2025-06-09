package com.sipsoft.licoreria.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .addServersItem(new Server().url("http://sipsoft.spring.informaticapp.com:2000").description("Servidor de Producción"))
                .addServersItem(new Server().url("http://localhost:2000").description("Servidor Local"))
                .info(new Info()
                        .title("API Licorería SipSoft")
                        .description("API REST para el sistema de gestión de licorerías")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("SipSoft")
                                .email("soporte@sipsoft.com"))
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT")));
    }
}
