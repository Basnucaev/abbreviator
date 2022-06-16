package com.abbreviator;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@OpenAPIDefinition(
        info = @Info(title = "Link abbreviator"
                , version = "1.0"
                , description = "The service allows users to shorten their links and redirects through abbreviated" +
                " links to user links.")
)
public class AbbreviatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(AbbreviatorApplication.class, args);
    }

}
