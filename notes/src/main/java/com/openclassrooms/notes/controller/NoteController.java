package com.openclassrooms.notes.controller;

import com.openclassrooms.notes.model.Note;
import com.openclassrooms.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/notes")
    public Note getNotes(@RequestParam int patientId){
        return noteService.noteById(patientId);
    }

    @PostMapping("/notes/add")
    public void addNote(@RequestBody Note note){
        noteService.saveNote(note);
    }

}
