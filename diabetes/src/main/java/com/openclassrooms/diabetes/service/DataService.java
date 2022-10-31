package com.openclassrooms.diabetes.service;

import com.openclassrooms.diabetes.model.Note;
import com.openclassrooms.diabetes.model.Patient;
import com.openclassrooms.diabetes.proxies.NoteProxy;
import com.openclassrooms.diabetes.proxies.PatientProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DataService {

    @Autowired
    private NoteProxy noteProxy;
    @Autowired
    private PatientProxy patientProxy;
    private List<Note> notes;
    private Patient patient;
    private String risk = "Not calculated";
    private int nbTerms;

    public String evaluatingWithId(int patientId){
        notes = noteProxy.getNotes(patientId);
        patient = patientProxy.getAPatient(patientId);
        calculateTerms();
        calculateRisk();

        return risk;
    }
    public String evaluatingWithName(String familyName){
        patient = patientProxy.patientByFamily(familyName);
        notes = noteProxy.getNotes(patient.getId());
        calculateTerms();
        calculateRisk();

        return risk;
    }

    private void calculateRisk() {

        //int age = Date.from(Instant.now()).getYear() + 1900 - Integer.valueOf(patient.getDob().substring(6));
        int age = Date.from(Instant.now()).getYear() + 1900 - Integer.valueOf(patient.getDob().substring(0,3));

        switch (patient.getSex()){
            case "M":
                //TODO
                if(age < 30){
                    if(nbTerms < 3){
                        risk = "None";
                    }else if(nbTerms < 5){
                        risk = "In Danger";
                    }else if(nbTerms >= 5){
                        risk = "Early onset";
                    }
                }else{
                    if(nbTerms < 2){
                        risk = "None";
                    }else if(nbTerms < 6){
                        risk = "Borderline";
                    }else if(nbTerms < 8){
                        risk = "In Danger";
                    }else if(nbTerms >= 8){
                        risk = "Early onset";
                    }
                }
                break;
            case "F":
                if(age < 30){
                    if(nbTerms < 4){
                        risk = "None";
                    }else if(nbTerms < 7){
                        risk = "In Danger";
                    }else if(nbTerms >= 7){
                        risk = "Early onset";
                    }
                }else{
                    if(nbTerms < 2){
                        risk = "None";
                    }else if(nbTerms < 6){
                        risk = "Borderline";
                    }else if(nbTerms < 8){
                        risk = "In Danger";
                    }else if(nbTerms >= 8){
                        risk = "Early onset";
                    }
                }
                break;
            default:
                break;
        }

    }

    private void calculateTerms() {
        String allnotes = "";
        for(int i = 0;i < notes.size();i++){
            allnotes = allnotes + " | " + notes.get(i).getNote();
        }

        List<String> listTerms = new ArrayList<>();
        listTerms.add("Hémoglobine A1C");
        listTerms.add("Microalbumine");
        listTerms.add("Taille");
        listTerms.add("Poids");
        listTerms.add("Fumeur");
        listTerms.add("Anormal");
        listTerms.add("Cholestérol");
        listTerms.add("Vertige");
        listTerms.add("Rechute");
        listTerms.add("Réaction");
        listTerms.add("Anticorps");

        for(int i = 0;i < listTerms.size();i++){
            if(allnotes.contains(listTerms.get(i))){
                nbTerms = nbTerms + 1;
            }
        }

    }

}
