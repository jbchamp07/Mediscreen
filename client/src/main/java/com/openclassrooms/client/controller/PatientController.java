package com.openclassrooms.client.controller;

import com.openclassrooms.client.beans.PatientBean;
import com.openclassrooms.client.proxies.PatientProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * The type Patient controller.
 */
@Controller
public class PatientController {

    private final PatientProxy patientProxy;

    /**
     * Instantiates a new Patient controller.
     *
     * @param patientProxy the patient proxy
     */
    public PatientController(PatientProxy patientProxy) {
        this.patientProxy = patientProxy;
    }

    /**
     * Accueil list string.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping("/")
    public String accueilList(Model model)
    {
        List<PatientBean> patientsList = patientProxy.PatientsList();
        model.addAttribute("patientsList",patientsList);
        return "patient/list";
    }

    /**
     * Accueil string.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping("/patient/list")
    public String accueil(Model model)
    {
        List<PatientBean> patientsList = patientProxy.PatientsList();
        model.addAttribute("patientsList",patientsList);
        return "patient/list";
    }

    /**
     * Add form string.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping("/patient/add")
    public String addForm(Model model)
    {
        model.addAttribute("patient",new PatientBean());
        return "patient/add";
    }

    /**
     * Update form string.
     *
     * @param patientId the patient id
     * @param model     the model
     * @return the string
     */
    @GetMapping("/patient/update")
    public String updateForm(@RequestParam int patientId, Model model)
    {
        PatientBean patient = patientProxy.getAPatient(patientId);
        model.addAttribute("patient",patient);
        return "patient/update";
    }

    /**
     * Delete form string.
     *
     * @param patientId the patient id
     * @param model     the model
     * @return the string
     */
    @GetMapping("/patient/delete")
    public String deleteForm(@RequestParam int patientId,Model model)
    {
        PatientBean patient = patientProxy.getAPatient(patientId);
        model.addAttribute("patient",patient);
        return "patient/delete";
    }

    /**
     * Add model and view.
     *
     * @param patient the patient
     * @param model   the model
     * @return the model and view
     */
    @PostMapping("/patient/add")
    public ModelAndView add(@ModelAttribute PatientBean patient, Model model){
        patientProxy.add(patient);
        model.addAttribute("message","patient added");
        List<PatientBean> patientsList = patientProxy.PatientsList();
        model.addAttribute("patientsList",patientsList);

        return new ModelAndView("redirect:/");
    }

    /**
     * Update model and view.
     *
     * @param patient the patient
     * @param model   the model
     * @return the model and view
     */
    @PostMapping("/patient/update")
    public ModelAndView update(@ModelAttribute PatientBean patient, Model model){
        patientProxy.update(patient);
        model.addAttribute("message","patient updated");
        List<PatientBean> patientsList = patientProxy.PatientsList();
        model.addAttribute("patientsList",patientsList);

        return new ModelAndView("redirect:/");
    }

    /**
     * Delete model and view.
     *
     * @param patient the patient
     * @param model   the model
     * @return the model and view
     */
    @PostMapping("/patient/delete")
    public ModelAndView delete(@ModelAttribute PatientBean patient, Model model){
        patientProxy.delete(patient.getId());
        model.addAttribute("message","patient deleted");
        List<PatientBean> patientsList = patientProxy.PatientsList();
        model.addAttribute("patientsList",patientsList);

        return new ModelAndView("redirect:/");
    }
}
