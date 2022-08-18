package com.openclassrooms.client.controller;

import com.openclassrooms.client.beans.PatientBean;
import com.openclassrooms.client.proxies.PatientProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PatientController {

    private final PatientProxy patientProxy;

    public PatientController(PatientProxy patientProxy) {
        this.patientProxy = patientProxy;
    }

    @GetMapping("/patient/list")
    public String accueil(Model model)
    {
        List<PatientBean> patientsList = patientProxy.PatientsList();
        model.addAttribute("patientsList",patientsList);
        return "patient/list";
    }
    @GetMapping("/patient/add")
    public String addForm(Model model)
    {
        return "patient/add";
    }
    @GetMapping("/patient/update")
    public String updateForm(@RequestParam int patientId, Model model)
    {
        PatientBean patient = patientProxy.getAPatient(patientId);
        model.addAttribute("patient",patient);
        return "patient/update";
    }
    @GetMapping("/patient/delete")
    public String deleteForm(@RequestParam int patientId,Model model)
    {
        PatientBean patient = patientProxy.getAPatient(patientId);
        model.addAttribute("patient",patient);
        return "patient/delete";
    }
    //TODO ajouter message a l'html
    @PostMapping("/patient/delete")
    public String add(@RequestBody PatientBean patient, Model model){
        patientProxy.add(patient);
        model.addAttribute("message","patient added");
        return "patient";
    }

    @PutMapping("/patient/update")
    public String update(@RequestBody PatientBean patient, Model model){
        patientProxy.update(patient);
        model.addAttribute("message","patient updated");
        return "patient";
    }

    @DeleteMapping("/patient/delete")
    public String delete(@RequestBody PatientBean patient, Model model){
        patientProxy.delete(patient.getId());
        model.addAttribute("message","patient deleted");
        return "patient";
    }
}
