package com.openclassrooms.notes.service;

import com.openclassrooms.notes.model.Note;
import com.openclassrooms.notes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public void saveNote(Note note){
        note.setDate(Date.from(Instant.now()).toString());
        noteRepository.save(note);
    }


    public List<Note> noteById(int patientId){
        return noteRepository.findByPatientId(patientId);
    }

    public void deleteNote(Note note) {
        noteRepository.delete(note);
    }

    public Note getANote(int id) {
        return noteRepository.findById(id).get();
    }
}
