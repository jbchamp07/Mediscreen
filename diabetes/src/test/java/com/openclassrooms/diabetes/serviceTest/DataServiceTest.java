package com.openclassrooms.diabetes.serviceTest;

import com.openclassrooms.diabetes.model.Note;
import com.openclassrooms.diabetes.model.Patient;
import com.openclassrooms.diabetes.proxies.NoteProxy;
import com.openclassrooms.diabetes.proxies.PatientProxy;
import com.openclassrooms.diabetes.service.DataService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class DataServiceTest {

    @InjectMocks
    private DataService dataService;
    @Mock
    private NoteProxy noteProxy;
    @Mock
    private PatientProxy patientProxy;
    private Patient patient;
    private Note note;


    @Before
    public void start(){
        note = new Note();
        patient = new Patient();
        note.setId(2);
        note.setNote("noteTest");
        note.setPatientId(1);
        patient.setId(1);
        patient.setAddress("addressTest");
        patient.setFamily("familyTest");
        patient.setSex("M");
        patient.setDob("01-01-2000");
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void evaluatingWithIdTestNone(){

        List<Note> list = new ArrayList<>();
        list.add(note);
        when(noteProxy.getNotes(1)).thenReturn(list);
        when(patientProxy.getAPatient(patient.getId())).thenReturn(patient);
        assertEquals("None",dataService.evaluatingWithId(patient.getId()));

    }

    @Test
    public void evaluatingWithNameTestNone(){

        List<Note> list = new ArrayList<>();
        list.add(note);
        when(noteProxy.getNotes(1)).thenReturn(list);
        when(patientProxy.patientByFamily(patient.getFamily())).thenReturn(patient);
        assertEquals("None",dataService.evaluatingWithId(patient.getId()));

    }

    @Test
    public void evaluatingWithIdTestEarlyOnset(){

        List<Note> list = new ArrayList<>();
        note.setNote("Vertige Vertige Vertige Vertige Vertige Vertige Vertige Vertige Vertige Vertige");
        list.add(note);
        when(noteProxy.getNotes(1)).thenReturn(list);
        when(patientProxy.getAPatient(patient.getId())).thenReturn(patient);
        assertEquals("None",dataService.evaluatingWithId(patient.getId()));

    }

    @Test
    public void evaluatingWithNameTestEarlyOnset(){

        List<Note> list = new ArrayList<>();
        note.setNote("Vertige Vertige Vertige Vertige Vertige Vertige Vertige Vertige Vertige Vertige");
        list.add(note);
        when(noteProxy.getNotes(1)).thenReturn(list);
        when(patientProxy.patientByFamily(patient.getFamily())).thenReturn(patient);
        assertEquals("None",dataService.evaluatingWithId(patient.getId()));

    }

}
