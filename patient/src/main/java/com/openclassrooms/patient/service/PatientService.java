package com.openclassrooms.patient.service;

import com.openclassrooms.patient.model.Patient;
import com.openclassrooms.patient.repository.PatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * The type Patient service.
 */
@Service
@Slf4j
public class PatientService {

    /**
     * The Logger.
     */
    Logger logger = LoggerFactory.getLogger(PatientService.class);

    @Autowired
    private PatientRepository patientRepository;

    /**
     * Get a patient by id patient.
     *
     * @param id the id
     * @return the patient
     */
    public Patient getAPatientById(int id){

        if(patientRepository.findById(id).get() != null){
            logger.info("Patient with id : " + id + " is found");
        }else{
            logger.error("Patient with id : " + id + " isn't found");
        }
        return patientRepository.findById(id).get();

    }

    /**
     * Patient list list.
     *
     * @return the list
     */
    public List<Patient> patientList(){
        logger.info("Patient list is return");
        return patientRepository.findAll();
    }

    /**
     * Add patient.
     *
     * @param patient the patient
     */
    public void addPatient(Patient patient){
        patientRepository.save(patient);
        if(patientRepository.findById(patient.getId()) != null){
            logger.info("Patient : " + patient + " is created");
        }else{
            logger.error("Patient : " + patient + " isn't created");
        }

    }

    /**
     * Update patient.
     *
     * @param patient the patient
     */
    public void updatePatient(Patient patient){
        patientRepository.save(patient);
        logger.info("Patient : " + patient + " is updated");
    }

    /**
     * Delete patient.
     *
     * @param patient the patient
     */
    public void deletePatient(Patient patient){
        patientRepository.delete(patient);
        if(patientRepository.findById(patient.getId()) != null){
            logger.error("Patient : " + patient + " isn't deleted");
        }else{
            logger.info("Patient : " + patient + " is deleted");
        }

    }

    /**
     * Patient by family patient.
     *
     * @param familyName the family name
     * @return the patient
     */
    public Patient patientByFamily(String familyName){
        if(patientRepository.findByFamily(familyName) != null){
            logger.info("Patient with familyName : " + familyName + " is found");
        }else{
            logger.error("Patient with familyName : " + familyName + " isn't found");
        }
        return patientRepository.findByFamily(familyName);
    }

}
