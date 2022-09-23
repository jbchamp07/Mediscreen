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

@Controller
public class NoteController {

    private final NoteProxy noteProxy;
    private final PatientProxy patientProxy;

    public NoteController(NoteProxy noteProxy, PatientProxy patientProxy) {
        this.noteProxy = noteProxy;
        this.patientProxy = patientProxy;
    }

    @GetMapping("/notes")
    public String noteList(@RequestParam int patientId, Model model) {
        List<NoteBean> notesList = noteProxy.getNotes(patientId);
        model.addAttribute("notesList",notesList);
        PatientBean patient = patientProxy.getAPatient(patientId);
        model.addAttribute("patient",patient);
        return "note/list";

    }
    @GetMapping("/note/add")
    public String addForm(@RequestParam int patientId, Model model) {
        PatientBean patient = patientProxy.getAPatient(patientId);
        model.addAttribute("patient",patient);
        model.addAttribute("note", new NoteBean());
        return "note/add";
    }
    @GetMapping("/note/update")
    public String updateForm(@RequestParam int id, Model model) {
        NoteBean note = noteProxy.updateNoteById(id);
        model.addAttribute("note",note);
        PatientBean patient = patientProxy.getAPatient(note.getPatientId());
        model.addAttribute("patient",patient);
        return "note/update";

    }
    @GetMapping("/note/delete")
    public String deleteForm(@RequestParam int id, Model model) {
        NoteBean note = noteProxy.deleteNoteById(id);
        model.addAttribute("note",note);
        return "note/delete";

    }

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
