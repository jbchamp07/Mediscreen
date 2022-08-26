package com.openclassrooms.client.controller;

import com.openclassrooms.client.beans.PatientBean;
import com.openclassrooms.client.proxies.DiabeteProxy;
import com.openclassrooms.client.proxies.PatientProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DiabeteController {

    private final DiabeteProxy diabeteProxy;
    private final PatientProxy patientProxy;

    public DiabeteController(DiabeteProxy diabeteProxy, PatientProxy patientProxy) {
        this.diabeteProxy = diabeteProxy;
        this.patientProxy = patientProxy;
    }

    @GetMapping("/assess")
    public String getDiabete(@RequestParam int patientId, Model model){
        PatientBean patient = patientProxy.getAPatient(patientId);
        model.addAttribute("patient",patient);
        model.addAttribute("result",diabeteProxy.assess(patientId));
        return "diabete/result";
    }

}
