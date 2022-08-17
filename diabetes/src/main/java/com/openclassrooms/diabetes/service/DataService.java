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
    private String risk = "None";
    private int nbTerms;

    public String evaluating(int patientId){
        notes = noteService.getNoteByPatientId(patientId);
        patient = patientService.getPatientById(patientId);
        calculateTerms();

        /*if(nbTerms == 0){
            risk = "None";
        }else if(nbTerms <= 2){
            if(patient.getDob().getYear() > 30){
                risk = "Borderline";
            }
        }else if(nbTerms == 3){
            if( (patient.getSex().equals("M")) && (patient.getDob().getYear() > 30) ){
                risk = "In Danger";
            }
        }else if(nbTerms == 4){
            if(patient.getSex().equals("F")){
                if(patient.getDob().getYear() < 30){
                    risk = "In Danger";
                }else{

                }
            }
        }else if(nbTerms >= 5){

        }*/


        switch (patient.getSex()){
            case "M":

                if(patient.getDob().getYear() < 30){
                    if(nbTerms == 0){
                        risk = "None";
                    }else if(nbTerms == 3){
                        risk = "In Danger";
                    }else if(nbTerms == 5){
                        risk = "Early onset";
                    }
                }else{
                    if(nbTerms == 2){
                        risk = "Borderline";
                    }else if(nbTerms == 6){
                        risk = "In Danger";
                    }else if(nbTerms >= 8){
                        risk = "Early onset";
                    }
                }


                break;
            case "F":


                if(patient.getDob().getYear() < 30){
                    if(nbTerms == 0){
                        risk = "None";
                    }else if(nbTerms == 4){
                        risk = "In Danger";
                    }else if(nbTerms == 7){
                        risk = "Early onset";
                    }
                }else{
                    if(nbTerms == 2){
                        risk = "Borderline";
                    }else if(nbTerms == 6){
                        risk = "In Danger";
                    }else if(nbTerms >= 8){
                        risk = "Early onset";
                    }
                }


                break;
            default:
                break;
        }



        return risk;
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
