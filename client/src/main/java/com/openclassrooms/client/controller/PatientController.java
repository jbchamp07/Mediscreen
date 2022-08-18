package com.openclassrooms.client.controller;

import com.openclassrooms.client.beans.PatientBean;
import com.openclassrooms.client.proxies.PatientProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PatientController {

    private final PatientProxy patientProxy;

    public PatientController(PatientProxy patientProxy) {
        this.patientProxy = patientProxy;
    }

    @RequestMapping("/patient")
    public String accueil(Model model)
    {
        List<PatientBean> patientsList = patientProxy.PatientsList();
        model.addAttribute("patientsList",patientsList);
        return "patient/list";

    }

}
