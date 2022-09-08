package com.openclassrooms.notes.controller;

import com.openclassrooms.notes.model.Note;
import com.openclassrooms.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/notes")
    public List<Note> getNotes(@RequestParam int patientId){
        return noteService.noteById(patientId);
    }

    @PostMapping("/notes/add")
    public void addNote(@RequestBody Note note){
        noteService.saveNote(note);
    }

    @PutMapping("/notes/update")
    public void updateNote(@RequestBody Note note){
        noteService.updateNote(note);
    }

    @DeleteMapping("/notes/delete")
    public void deleteNote(@RequestBody Note note){
        noteService.deleteNote(note);
    }

    @GetMapping("note/update")
    public Note updateNoteById(@RequestParam int id){
        return noteService.getANote(id);
    }

    @GetMapping("note/delete")
    public Note deleteNoteById(@RequestParam int id){
        return noteService.getANote(id);
    }

}
