package com.rm.rectificadoraMundial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class RectificadoraMundialApplication extends SpringBootServletInitializer {

	//Prueba pr
    public static void main(String[] args) {
        SpringApplication.run(RectificadoraMundialApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(RectificadoraMundialApplication.class);
    }
}
