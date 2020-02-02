package com.github.raymondtang310.fireemblemapi;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvEntry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.StandardEnvironment;

import java.util.Map;
import java.util.stream.Collectors;

@SpringBootApplication
public class FireEmblemAPIApplication {

    public static void main(String[] args) {
        // Set environment variables from dotenv file for local environment
        if (System.getenv("APP_ENV") == null) {
            Map<String, Object> env = Dotenv.load()
                    .entries()
                    .stream()
                    .collect(
                            Collectors.toMap(DotenvEntry::getKey, DotenvEntry::getValue));

            new SpringApplicationBuilder(FireEmblemAPIApplication.class)
                    .environment(new StandardEnvironment() {
                        @Override
                        protected void customizePropertySources(MutablePropertySources propertySources) {
                            super.customizePropertySources(propertySources);
                            propertySources.addLast(new MapPropertySource("dotenvProperties", env));
                        }
                    }).run(args);
        } else {
            SpringApplication.run(FireEmblemAPIApplication.class, args);
        }
    }

}