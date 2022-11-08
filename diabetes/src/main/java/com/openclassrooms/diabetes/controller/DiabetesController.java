package com.openclassrooms.diabetes.controller;

import com.openclassrooms.diabetes.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Diabetes controller.
 */
@RestController
public class DiabetesController {

    @Autowired
    private DataService dataService;


    /**
     * Assess string.
     *
     * @param patientId the patient id
     * @return the string
     */
    @GetMapping("/assess")
    public String assess(@RequestParam int patientId){
        return dataService.evaluatingWithId(patientId);
    }

    /**
     * Assess name string.
     *
     * @param familyName the family name
     * @return the string
     */
    @GetMapping("/assessName")
    public String assessName(@RequestParam String familyName){
        return dataService.evaluatingWithName(familyName);
    }



}
