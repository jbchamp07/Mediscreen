package com.openclassrooms.diabetes.controller;

import com.openclassrooms.diabetes.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DiabetesController {

    @Autowired
    private DataService dataService;


    @GetMapping("/assess")
    public String assess(@RequestParam int patientId){
        return dataService.toString();
    }
}
