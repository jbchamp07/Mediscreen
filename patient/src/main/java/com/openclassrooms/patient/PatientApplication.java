package com.openclassrooms.patient;

import com.openclassrooms.patient.controller.PatientController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * The type Patient application.
 */
@SpringBootApplication
public class PatientApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(PatientApplication.class, args);
    }

}
