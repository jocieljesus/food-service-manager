package com.adjt.food_service_manager.configuracoes;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("FOOD SERVICE MANAGER API")
                        .description("Documentação da API FOOD SERVICE MANAGER")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("FOOD SERVICE MANAGER S.A.")
                                .email("Contato@foodservice.com"))
                        .license(new License()
                                .name("Licença Comercial")))
                .externalDocs(new ExternalDocumentation()
                        .description("Repositório no GitHub")
                        .url("https://github.com/jocieljesus/food-service-manager"));
    }
}
