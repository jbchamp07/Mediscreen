package com.openclassrooms.diabetes.service;

import com.openclassrooms.diabetes.model.Note;
import com.openclassrooms.diabetes.model.Patient;
import com.openclassrooms.diabetes.proxies.NoteProxy;
import com.openclassrooms.diabetes.proxies.PatientProxy;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The type Data service.
 */
@Service
@Slf4j
public class DataService {

    /**
     * The Logger.
     */
    Logger logger = LoggerFactory.getLogger(DataService.class);

    @Autowired
    private NoteProxy noteProxy;
    @Autowired
    private PatientProxy patientProxy;
    private List<Note> notes;
    private Patient patient;
    private String risk = "Not calculated";
    private int nbTerms;

    /**
     * Evaluating with id string.
     *
     * @param patientId the patient id
     * @return the string
     */
    public String evaluatingWithId(int patientId){
        notes = noteProxy.getNotes(patientId);
        if(notes.size() >= 1){
            logger.info("note list : " + notes + " is found");
        }else{
            logger.error("note list : " + notes + " isn't found");
        }

        patient = patientProxy.getAPatient(patientId);

        if(patient != null){
            logger.info("patient : " + patient + " is found");
        }else{
            logger.error("patient : " + patient + " isn't found");
        }

        calculateTerms();
        logger.info("patient terms are calculated : " + nbTerms);
        calculateRisk();
        logger.info("patient risk is : " + risk);
        return risk;
    }

    /**
     * Evaluating with name string.
     *
     * @param familyName the family name
     * @return the string
     */
    public String evaluatingWithName(String familyName){
        patient = patientProxy.patientByFamily(familyName);
        if(patient != null){
            logger.info("patient : " + patient + " is found");
        }else{
            logger.error("patient : " + patient + " isn't found");
        }
        notes = noteProxy.getNotes(patient.getId());
        if(notes.size() >= 1){
            logger.info("note list : " + notes + " is found");
        }else{
            logger.error("note list : " + notes + " isn't found");
        }
        calculateTerms();
        logger.info("patient terms are calculated : " + nbTerms);
        calculateRisk();
        logger.info("patient risk is : " + risk);
        return risk;
    }

    private void calculateRisk() {

        int age = Date.from(Instant.now()).getYear() + 1900 - Integer.valueOf(patient.getDob().substring(0,3));

        switch (patient.getSex()){
            case "M":
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
