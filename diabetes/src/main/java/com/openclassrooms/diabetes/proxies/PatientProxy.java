package com.openclassrooms.diabetes.proxies;

import com.openclassrooms.diabetes.model.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * The interface Patient proxy.
 */
@FeignClient(name = "microservice-patient", url = "patient:9001")
public interface PatientProxy {

    /**
     * Gets a patient.
     *
     * @param patientId the patient id
     * @return the a patient
     */
    @GetMapping("/patient")
    Patient getAPatient(@RequestParam int patientId);

    /**
     * Patient by family patient.
     *
     * @param familyName the family name
     * @return the patient
     */
    @GetMapping("/patientfamily")
    Patient patientByFamily(@RequestParam String familyName);

}
