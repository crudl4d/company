package com.project.company;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.sql.SQLException;
import java.util.Arrays;

@SpringBootApplication
@ComponentScan({"com.project.company"})
public class Main {

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(Main.class);

        builder.headless(false);

        ConfigurableApplicationContext context = builder.run(args);
        //Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
