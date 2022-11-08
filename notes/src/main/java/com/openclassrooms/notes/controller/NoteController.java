package com.openclassrooms.notes.controller;

import com.openclassrooms.notes.model.Note;
import com.openclassrooms.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Note controller.
 */
@RestController
public class NoteController {

    @Autowired
    private NoteService noteService;

    /**
     * Get notes list.
     *
     * @param patientId the patient id
     * @return the list
     */
    @GetMapping("/notes")
    public List<Note> getNotes(@RequestParam int patientId){
        return noteService.noteById(patientId);
    }

    /**
     * Add note.
     *
     * @param note the note
     */
    @PostMapping("/notes/add")
    public void addNote(@RequestBody Note note){
        noteService.saveNote(note);
    }

    /**
     * Update note.
     *
     * @param note the note
     */
    @PutMapping("/notes/update")
    public void updateNote(@RequestBody Note note){
        noteService.updateNote(note);
    }

    /**
     * Delete note.
     *
     * @param note the note
     */
    @DeleteMapping("/notes/delete")
    public void deleteNote(@RequestBody Note note){
        noteService.deleteNote(note);
    }

    /**
     * Update note by id note.
     *
     * @param id the id
     * @return the note
     */
    @GetMapping("note/update")
    public Note updateNoteById(@RequestParam int id){
        return noteService.getANote(id);
    }

    /**
     * Delete note by id note.
     *
     * @param id the id
     * @return the note
     */
    @GetMapping("note/delete")
    public Note deleteNoteById(@RequestParam int id){
        return noteService.getANote(id);
    }

}
