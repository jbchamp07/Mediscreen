package com.openclassrooms.notes.repository;

import com.openclassrooms.notes.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NoteRepository extends MongoRepository<Note,Integer> {

    public Optional<Note> findByPatientId(int patientId);

}
