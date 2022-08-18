package com.openclassrooms.patient.controller;

import com.openclassrooms.patient.model.Patient;
import com.openclassrooms.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.openclassrooms.patient.repository.PatientRepository;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/patient/list")
    public List<Patient> PatientsList() {
        return patientService.patientList();
    }

    //TODO
    @GetMapping("/patient")
    public Patient getAPatient(@RequestParam int patientId) {
        return patientService.getAPatientById(patientId);
    }

    @PostMapping("/patient/add")
    public void add(@RequestBody Patient patient) {
        patientService.addPatient(patient);
    }

    @PutMapping("/patient/update")
    public void update(@RequestBody Patient patient) {
        patientService.updatePatient(patient);
    }

    @DeleteMapping("/patient/delete")
    public void delete(@RequestParam int patientId) {
        Patient patient = patientService.getAPatientById(patientId);
        patientService.deletePatient(patient);
    }
}
