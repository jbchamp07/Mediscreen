package com.openclassrooms.client.controller;

import com.openclassrooms.client.beans.NoteBean;
import com.openclassrooms.client.beans.PatientBean;
import com.openclassrooms.client.proxies.NoteProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class NoteController {

    private final NoteProxy noteProxy;

    public NoteController(NoteProxy noteProxy) {
        this.noteProxy = noteProxy;
    }

    @GetMapping("/note")
    public String noteList(Model model) {
        List<NoteBean> notesList = noteProxy.NotesList();
        model.addAttribute("notesList",notesList);
        return "note/list";

    }
    @GetMapping("/note/add")
    public String addForm(Model model) {
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
        noteProxy.add(note);
        model.addAttribute("message","note added");
        return "note";
    }

    @PutMapping("note/update")
    public String update(@RequestBody NoteBean note, Model model){
        noteProxy.update(note);
        model.addAttribute("message","note updated");
        return "note";
    }

    @DeleteMapping("note/delete")
    public String delete(@RequestBody NoteBean note, Model model){
        noteProxy.delete(note.getId());
        model.addAttribute("message","note deleted");
        return "note";
    }

}
