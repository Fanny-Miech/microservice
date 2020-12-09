package com.service.microservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// @Configuration remplace un fichier de config classique en XML
// @Configuration donne accès à la classe Docket qui gère toutes les configurations
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2) // on initialise un objet Docket en précisant qu'on souhaite utiliser SWAGGER_2
                .select() // permet d'initialiser une classe du nom de ApiSelectorBuilder
                .apis(RequestHandlerSelectors.basePackage("com.service.microservice")) // permet de filtrer la documentation à exposer selon les contrôleurs. Ainsi, vous pouvez cacher la documentation d'une partie privée ou interne de votre API. Dans ce cas, nous avons utilisé RequestHandlerSelectors.any().
                .paths(PathSelectors.any()) // permet de filtrer la doc des méthodes qui répondent à des requêtes commençant par "/public"
                .build();
    }
}
