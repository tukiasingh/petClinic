package com.example.petclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PetclinicApplication {

    public static void main(String[] args) {
        // Externalize the Spring Properties
//        System.setProperty("spring.config.location", "application.properties");
        SpringApplication.run(PetclinicApplication.class, args);
    }

}
