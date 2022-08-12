package com.openclassrooms.patient.service;

import com.openclassrooms.patient.model.Patient;
import com.openclassrooms.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient getAPatientById(int id){
        return patientRepository.findById(id).get();
    }

    public List<Patient> patientList(){
        return patientRepository.findAll();
    }

    public void addPatient(Patient patient){
        patientRepository.save(patient);
    }

    public void updatePatient(Patient patient){
        patientRepository.save(patient);
    }

    public void deletePatient(Patient patient){
        patientRepository.delete(patient);
    }

}
