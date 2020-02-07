package com.github.raymondtang310.fireemblemapi.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * SwaggerConfiguration is a {@link Configuration} that sets up Swagger documentation for this Spring Boot application.
 * <p>
 * Created February 02, 2020.
 *
 * @author Raymond Tang
 * @version %I%, %G%
 * @since 1.0.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    /**
     * Configures Swagger documentation for this Spring Boot application.
     *
     * @return a {@link Docket} configuring Swagger documentation for this Spring Boot application
     * @since 1.0.0
     */
    @Bean
    public Docket configure() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.github.raymondtang310.fireemblemapi"))
                .build()
                .apiInfo(new ApiInfo(
                        "Fire Emblem API",
                        "REST API for providing Fire Emblem data",
                        "1.0.0",
                        null,
                        new Contact("Raymond Tang", "https://github.com/raymondtang310", "raymondtang310@gmail.com"),
                        "MIT License",
                        "https://github.com/raymondtang310/fire-emblem-api/blob/master/LICENSE",
                        Collections.emptyList()
                ));
    }
}
