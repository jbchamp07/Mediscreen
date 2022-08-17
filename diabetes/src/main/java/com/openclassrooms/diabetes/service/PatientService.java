package com.openclassrooms.diabetes.service;

import com.openclassrooms.diabetes.model.Patient;
import com.openclassrooms.diabetes.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient getPatientById(int patientId){
        return patientRepository.findById(patientId).get();
    }
    public Patient getPatientByFamilyName(String familyName){
        return patientRepository.findByFamily(familyName);
    }

}
