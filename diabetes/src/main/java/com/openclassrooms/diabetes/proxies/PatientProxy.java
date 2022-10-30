package com.openclassrooms.diabetes.proxies;

import com.openclassrooms.diabetes.model.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "microservice-patient", url = "patient:9001")
public interface PatientProxy {

    @GetMapping("/patient")
    Patient getAPatient(@RequestParam int patientId);

    @GetMapping("/patientfamily")
    Patient patientByFamily(@RequestParam String familyName);

}
