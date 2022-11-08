package com.openclassrooms.patient.repository;

import com.openclassrooms.patient.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Patient repository.
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {

    /**
     * Find by family patient.
     *
     * @param patientId the patient id
     * @return the patient
     */
    public Patient findByFamily(String patientId);

}
