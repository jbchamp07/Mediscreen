package com.openclassrooms.client.controller;

import com.openclassrooms.client.beans.NoteBean;
import com.openclassrooms.client.beans.PatientBean;
import com.openclassrooms.client.proxies.NoteProxy;
import com.openclassrooms.client.proxies.PatientProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * The type Note controller.
 */
@Controller
public class NoteController {

    private final NoteProxy noteProxy;
    private final PatientProxy patientProxy;

    /**
     * Instantiates a new Note controller.
     *
     * @param noteProxy    the note proxy
     * @param patientProxy the patient proxy
     */
    public NoteController(NoteProxy noteProxy, PatientProxy patientProxy) {
        this.noteProxy = noteProxy;
        this.patientProxy = patientProxy;
    }

    /**
     * Note list string.
     *
     * @param patientId the patient id
     * @param model     the model
     * @return the string
     */
    @GetMapping("/notes")
    public String noteList(@RequestParam int patientId, Model model) {
        List<NoteBean> notesList = noteProxy.getNotes(patientId);
        model.addAttribute("notesList",notesList);
        PatientBean patient = patientProxy.getAPatient(patientId);
        model.addAttribute("patient",patient);
        return "note/list";

    }

    /**
     * Add form string.
     *
     * @param patientId the patient id
     * @param model     the model
     * @return the string
     */
    @GetMapping("/note/add")
    public String addForm(@RequestParam int patientId, Model model) {
        PatientBean patient = patientProxy.getAPatient(patientId);
        model.addAttribute("patient",patient);
        model.addAttribute("note", new NoteBean());
        return "note/add";
    }

    /**
     * Update form string.
     *
     * @param id    the id
     * @param model the model
     * @return the string
     */
    @GetMapping("/note/update")
    public String updateForm(@RequestParam int id, Model model) {
        NoteBean note = noteProxy.updateNoteById(id);
        model.addAttribute("note",note);
        PatientBean patient = patientProxy.getAPatient(note.getPatientId());
        model.addAttribute("patient",patient);
        return "note/update";

    }

    /**
     * Delete form string.
     *
     * @param id    the id
     * @param model the model
     * @return the string
     */
    @GetMapping("/note/delete")
    public String deleteForm(@RequestParam int id, Model model) {
        NoteBean note = noteProxy.deleteNoteById(id);
        model.addAttribute("note",note);
        return "note/delete";

    }

    /**
     * Add model and view.
     *
     * @param note  the note
     * @param model the model
     * @return the model and view
     */
    @PostMapping("/note/add")
    public ModelAndView add(@ModelAttribute NoteBean note, Model model){

        noteProxy.addNote(note);
        model.addAttribute("message","note added");

        List<NoteBean> notesList = noteProxy.getNotes(note.getPatientId());
        model.addAttribute("notesList",notesList);
        PatientBean patient = patientProxy.getAPatient(note.getPatientId());
        model.addAttribute("patient",patient);
        //TODO faire sa partout
        return new ModelAndView("redirect:/notes?patientId=" + note.getPatientId());
    }

    /**
     * Update model and view.
     *
     * @param note  the note
     * @param model the model
     * @return the model and view
     */
    @PostMapping("/note/update")
    public ModelAndView update(@ModelAttribute NoteBean note, Model model){

        noteProxy.updateNote(note);
        model.addAttribute("message","note updated");

        List<NoteBean> notesList = noteProxy.getNotes(note.getPatientId());
        model.addAttribute("notesList",notesList);
        PatientBean patient = patientProxy.getAPatient(note.getPatientId());
        model.addAttribute("patient",patient);

        return new ModelAndView("redirect:/notes?patientId=" + note.getPatientId());
    }

    /**
     * Delete model and view.
     *
     * @param note  the note
     * @param model the model
     * @return the model and view
     */
    @PostMapping("/note/delete")
    public ModelAndView delete(@ModelAttribute NoteBean note, Model model){

        noteProxy.deleteNote(note);
        model.addAttribute("message","note deleted");

        List<NoteBean> notesList = noteProxy.getNotes(note.getPatientId());
        model.addAttribute("notesList",notesList);
        PatientBean patient = patientProxy.getAPatient(note.getPatientId());
        model.addAttribute("patient",patient);

        return new ModelAndView("redirect:/notes?patientId=" + note.getPatientId());
    }

}
