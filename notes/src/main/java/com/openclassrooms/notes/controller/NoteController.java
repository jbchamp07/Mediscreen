package com.openclassrooms.notes.controller;

import com.openclassrooms.notes.model.Note;
import org.springframework.web.bind.annotation.*;

@RestController
public class NoteController {


    @GetMapping("/notes")
    public void getNotes(@RequestParam int patientId){

    }

    @PostMapping("/notes/add")
    public void addNote(@RequestBody Note note){

    }

}
