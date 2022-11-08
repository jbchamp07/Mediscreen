package com.openclassrooms.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * The type Client application.
 */
@SpringBootApplication
@EnableFeignClients("com.openclassrooms.client")
public class ClientApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

}
