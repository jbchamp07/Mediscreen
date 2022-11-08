package com.openclassrooms.client.proxies;

import com.openclassrooms.client.beans.PatientBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The interface Patient proxy.
 */
@FeignClient(name = "microservice-patient", url = "patient:9001")
public interface PatientProxy {

    /**
     * Patients list list.
     *
     * @return the list
     */
    @GetMapping(value = "/patient/list")
    List<PatientBean> PatientsList();

    /*@GetMapping( value = "/patient/{id}")
    PatientBean aPatient(@PathVariable("id") int id);*/

    /**
     * Add.
     *
     * @param patient the patient
     */
    @PostMapping(value = "/patient/add")
    void add(@RequestBody PatientBean patient);

    /**
     * Update.
     *
     * @param patient the patient
     */
    @PutMapping(value = "/patient/update")
    void update(@RequestBody PatientBean patient);

    /**
     * Delete.
     *
     * @param patientId the patient id
     */
    @DeleteMapping(value = "/patient/delete")
    void delete(@RequestParam int patientId);

    /**
     * Gets a patient.
     *
     * @param patientId the patient id
     * @return the a patient
     */
    @GetMapping(value = "/patient")
    PatientBean getAPatient(@RequestParam int patientId);
}
