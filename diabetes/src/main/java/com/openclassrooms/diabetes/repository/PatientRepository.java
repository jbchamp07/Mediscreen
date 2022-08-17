package com.openclassrooms.diabetes.repository;

import com.openclassrooms.diabetes.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {

    public Patient findByFamily(String patientId);

}
