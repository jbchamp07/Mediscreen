package com.openclassrooms.diabetes.service;

import com.openclassrooms.diabetes.model.Note;
import com.openclassrooms.diabetes.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataService {

    @Autowired
    private NoteService noteService;
    @Autowired
    private PatientService patientService;
    private List<Note> notes;
    private Patient patient;
    private String risk;
    private int nbTerms;

    public String evaluating(int patientId){
        notes = noteService.getNoteByPatientId(patientId);
        patient = patientService.getPatientById(patientId);
        calculateTerms();
    }

    private void calculateTerms() {
        String allnotes = "";
        for(int i = 0;i < notes.size();i++){
            allnotes = allnotes + " | " + notes.get(i).getNote();
        }

        List<String> listTerms = new ArrayList<>();

        for(int i = 0;i < listTerms.size();i++){

        }

    }

}
