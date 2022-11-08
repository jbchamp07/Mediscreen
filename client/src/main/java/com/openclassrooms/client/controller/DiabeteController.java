package com.openclassrooms.client.controller;

import com.openclassrooms.client.beans.PatientBean;
import com.openclassrooms.client.proxies.DiabeteProxy;
import com.openclassrooms.client.proxies.PatientProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * The type Diabete controller.
 */
@Controller
public class DiabeteController {

    private final DiabeteProxy diabeteProxy;
    private final PatientProxy patientProxy;

    /**
     * Instantiates a new Diabete controller.
     *
     * @param diabeteProxy the diabete proxy
     * @param patientProxy the patient proxy
     */
    public DiabeteController(DiabeteProxy diabeteProxy, PatientProxy patientProxy) {
        this.diabeteProxy = diabeteProxy;
        this.patientProxy = patientProxy;
    }

    /**
     * Get diabete string.
     *
     * @param patientId the patient id
     * @param model     the model
     * @return the string
     */
    @GetMapping("/assess")
    public String getDiabete(@RequestParam int patientId, Model model){
        PatientBean patient = patientProxy.getAPatient(patientId);
        model.addAttribute("patient",patient);
        model.addAttribute("result",diabeteProxy.assess(patientId));
        return "diabete/result";
    }

}
