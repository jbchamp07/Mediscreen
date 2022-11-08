package com.openclassrooms.diabetes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * The type Diabetes application.
 */
@SpringBootApplication
@EnableFeignClients("com.openclassrooms.diabetes")
public class DiabetesApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(DiabetesApplication.class, args);
    }

}
