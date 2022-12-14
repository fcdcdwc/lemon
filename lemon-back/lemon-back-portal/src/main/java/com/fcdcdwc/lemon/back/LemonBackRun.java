package com.fcdcdwc.lemon.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableOpenApi
public class LemonBackRun extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(LemonBackRun.class, args);
    }

}

