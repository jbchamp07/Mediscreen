package com.openclassrooms.patient.controller;

import com.openclassrooms.patient.model.Patient;
import com.openclassrooms.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.openclassrooms.patient.repository.PatientRepository;

import java.util.List;

/**
 * The type Patient controller.
 */
@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    /**
     * Patients list list.
     *
     * @return the list
     */
    @GetMapping("/patient/list")
    public List<Patient> PatientsList() {
        return patientService.patientList();
    }


    /**
     * Gets a patient.
     *
     * @param patientId the patient id
     * @return the a patient
     */
    @GetMapping("/patient")
    public Patient getAPatient(@RequestParam int patientId) {
        return patientService.getAPatientById(patientId);
    }

    /**
     * Add.
     *
     * @param patient the patient
     */
    @PostMapping("/patient/add")
    public void add(@RequestBody Patient patient) {
        patientService.addPatient(patient);
    }

    /**
     * Update.
     *
     * @param patient the patient
     */
    @PutMapping("/patient/update")
    public void update(@RequestBody Patient patient) {
        patientService.updatePatient(patient);
    }

    /**
     * Delete.
     *
     * @param patientId the patient id
     */
    @DeleteMapping("/patient/delete")
    public void delete(@RequestParam int patientId) {
        Patient patient = patientService.getAPatientById(patientId);
        patientService.deletePatient(patient);
    }

    /**
     * Patient by family patient.
     *
     * @param familyName the family name
     * @return the patient
     */
    @GetMapping("/patientfamily")
    public Patient patientByFamily(@RequestParam String familyName){
        return patientService.patientByFamily(familyName);
    }
}
