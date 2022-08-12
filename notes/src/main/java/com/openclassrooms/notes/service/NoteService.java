package com.openclassrooms.notes.service;

import com.openclassrooms.notes.model.Note;
import com.openclassrooms.notes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public void saveNote(Note note){
        noteRepository.save(note);
    }

    //TODO
    public Note noteById(int patientId){
        return noteRepository.findByPatientId(patientId).get();
    }

}
