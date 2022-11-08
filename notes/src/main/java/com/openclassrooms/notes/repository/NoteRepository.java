package com.openclassrooms.notes.repository;

import com.openclassrooms.notes.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * The interface Note repository.
 */
@Repository
public interface NoteRepository extends MongoRepository<Note,Integer> {

    /**
     * Find by patient id list.
     *
     * @param patientId the patient id
     * @return the list
     */
    public List<Note> findByPatientId(int patientId);

}
