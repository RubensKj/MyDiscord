package com.mydiscord.Configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@EntityScan("com.mydiscord.Models")
@ComponentScan("com.mydiscord.Services")
@ComponentScan(basePackages = {"com.mydiscord.Security", "com.mydiscord.Configuration", "com.mydiscord.Services", "com.mydiscord.Controllers"})
@EnableJpaRepositories(basePackages = "com.mydiscord.Repositories")
public class ConfigurationOfApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigurationOfApplication.class, args);
    }

}
