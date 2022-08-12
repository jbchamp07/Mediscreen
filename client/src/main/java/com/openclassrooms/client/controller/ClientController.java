package com.openclassrooms.client.controller;

import com.openclassrooms.client.beans.PatientBean;
import com.openclassrooms.client.proxies.PatientProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ClientController {

    private final PatientProxy patientProxy;

    public ClientController(PatientProxy patientProxy) {
        this.patientProxy = patientProxy;
    }

    @RequestMapping("/patient")
    public String accueil(Model model)
    {
        List<PatientBean> patientsList = patientProxy.PatientsList();
        model.addAttribute("patientsList",patientsList);
        return "Accueil";

    }

}
