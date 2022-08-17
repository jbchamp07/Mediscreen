package com.openclassrooms.diabetes.service;

import com.openclassrooms.diabetes.model.Note;
import com.openclassrooms.diabetes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public List<Note> getNoteByPatientId(int patientId){
        return noteRepository.findByPatientId(patientId);
    }

}
