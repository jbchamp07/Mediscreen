package com.openclassrooms.patient.service;

import com.openclassrooms.patient.model.Patient;
import com.openclassrooms.patient.repository.PatientRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * The type Patient service test.
 */
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PatientServiceTest {

    @InjectMocks
    private PatientService patientService;
    @Mock
    private PatientRepository patientRepository;
    private Patient patient;

    /**
     * Start.
     */
    @BeforeAll
    public void start(){

        patient = new Patient();
        patient.setId(1);
        patient.setAddress("addressTest");
        patient.setFamily("familyTest");
        patient.setGiven("givenTest");
        patient.setPhone("0123456789");
        patient.setSex("M");
        patient.setDob("01/01/2000");

        MockitoAnnotations.openMocks(this);

    }


    /**
     * Get a patient by id test.
     */
    @Test
    public void getAPatientByIdTest(){

        when(patientRepository.findById(patient.getId())).thenReturn(java.util.Optional.ofNullable(patient));
        assertEquals(1,patientService.getAPatientById(patient.getId()).getId());

    }

    /**
     * Patient list test.
     */
    @Test
    public void patientListTest(){
        List<Patient> list = new ArrayList<>();
        list.add(patient);
        when(patientRepository.findAll()).thenReturn(list);
        assertEquals(1,patientService.patientList().size());
    }

    /**
     * Add patient test.
     */
    @Test
    public void addPatientTest(){
        when(patientRepository.save(patient)).thenReturn(patient);
        patientService.addPatient(patient);
        when(patientRepository.findById(1)).thenReturn(java.util.Optional.ofNullable(patient));
        assertEquals("addressTest",patientService.getAPatientById(1).getAddress());
    }

    /**
     * Update patient test.
     */
    @Test
    public void updatePatientTest(){
        patient.setSex("F");
        when(patientRepository.save(patient)).thenReturn(patient);
        patientService.updatePatient(patient);
        when(patientRepository.findById(1)).thenReturn(java.util.Optional.ofNullable(patient));
        assertEquals("F",patientService.getAPatientById(1).getSex());
        patient.setSex("M");
    }

    /**
     * Delete patient test.
     */
    @Test
    public void deletePatientTest(){

        patientService.deletePatient(patient);
        verify(patientRepository,times(1)).delete(patient);

    }

    /**
     * Patient by family test.
     */
    @Test
    public void patientByFamilyTest(){
        when(patientRepository.findByFamily(patient.getFamily())).thenReturn(patient);
        assertEquals(1,patientService.patientByFamily(patient.getFamily()).getId());
    }

}
