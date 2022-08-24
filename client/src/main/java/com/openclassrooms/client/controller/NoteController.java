package com.openclassrooms.client.controller;

import com.openclassrooms.client.beans.NoteBean;
import com.openclassrooms.client.beans.PatientBean;
import com.openclassrooms.client.proxies.NoteProxy;
import com.openclassrooms.client.proxies.PatientProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class NoteController {

    private final NoteProxy noteProxy;
    private final PatientProxy patientProxy;

    public NoteController(NoteProxy noteProxy, PatientProxy patientProxy) {
        this.noteProxy = noteProxy;
        this.patientProxy = patientProxy;
    }

    @GetMapping("/note")
    public String noteList(Model model) {
        List<NoteBean> notesList = noteProxy.getNotes();
        model.addAttribute("notesList",notesList);
        return "note/list";

    }
    @GetMapping("/note/add")
    public String addForm(int patientId, Model model) {
        PatientBean patient = patientProxy.getAPatient(patientId);
        model.addAttribute("patient",patient);
        return "note/add";
    }
    @GetMapping("/note/update")
    public String updateForm(@PathVariable int patientId, Model model) {
        NoteBean note = noteProxy.getNote(patientId);
        model.addAttribute("note",note);
        return "note/update";

    }
    @GetMapping("/note/delete")
    public String deleteForm(@PathVariable int id, Model model) {
        NoteBean note = noteProxy.getNoteId(id);
        model.addAttribute("note",note);
        return "note/delete";

    }
    //TODO ajouter message a l'html
    @PostMapping("note/add")
    public String add(@RequestBody NoteBean note, Model model){
        noteProxy.addNote(note);
        model.addAttribute("message","note added");
        return "note/list";
    }

    @PutMapping("note/update")
    public String update(@RequestBody NoteBean note, Model model){
        noteProxy.updateNote(note);
        model.addAttribute("message","note updated");
        return "note/list";
    }

    @DeleteMapping("note/delete")
    public String delete(@RequestBody NoteBean note, Model model){
        noteProxy.deleteNote(note.getId());
        model.addAttribute("message","note deleted");
        return "note/list";
    }

}
