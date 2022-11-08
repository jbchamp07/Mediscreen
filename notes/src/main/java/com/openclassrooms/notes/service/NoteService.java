package com.openclassrooms.notes.service;

import com.openclassrooms.notes.model.CustomSequences;
import com.openclassrooms.notes.model.Note;
import com.openclassrooms.notes.repository.NoteRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * The type Note service.
 */
@Service
@Slf4j
public class NoteService {

    /**
     * The Logger.
     */
    Logger logger = LoggerFactory.getLogger(NoteService.class);

    private MongoOperations mongoOperations;

    /**
     * Instantiates a new Note service.
     *
     * @param mongoOperations the mongo operations
     */
    public NoteService(MongoOperations mongoOperations){
        this.mongoOperations = mongoOperations;
    }

    /**
     * Gets next sequence.
     *
     * @param seqName the seq name
     * @return the next sequence
     */
    public int getNextSequence(String seqName)
    {
        CustomSequences counter = mongoOperations.findAndModify(
                query(where("_id").is(seqName)),
                new Update().inc("seq",1),
                options().returnNew(true).upsert(true),
                CustomSequences.class);
        return counter.getSeq();
    }

    @Autowired
    private NoteRepository noteRepository;

    /**
     * Save note.
     *
     * @param note the note
     */
    public void saveNote(Note note){
        note.setDate(Date.from(Instant.now()).toString());

        note.setId(getNextSequence("customSequences"));

        noteRepository.save(note);
        if(noteRepository.findById(note.getId()).get() != null){
            logger.info("note : " + note + " is created");
        }else{
            logger.error("note : " + note + " isn't created");
        }
    }

    /**
     * Update note.
     *
     * @param note the note
     */
    public void updateNote(Note note){
        noteRepository.save(note);
        logger.info("note : " + note + " is updated");
    }

    /**
     * Note by id list.
     *
     * @param patientId the patient id
     * @return the list
     */
    public List<Note> noteById(int patientId){
        if(noteRepository.findByPatientId(patientId) != null){
            logger.info("note with patientId : " + patientId + " is found");
        }else{
            logger.error("note with patientId : " + patientId + " isn't found");
        }
        return noteRepository.findByPatientId(patientId);
    }

    /**
     * Delete note.
     *
     * @param note the note
     */
    public void deleteNote(Note note) {
        noteRepository.delete(note);
        if(noteRepository.findById(note.getId()) != null){
            logger.error("note : " + note + " isn't deleted");
        }else{
            logger.info("note : " + note + " is deleted");
        }
    }

    /**
     * Gets a note.
     *
     * @param id the id
     * @return the a note
     */
    public Note getANote(int id) {
        if(noteRepository.findById(id) != null){
            logger.info("note with id : " + id + " is found");
        }else{
            logger.error("note with id : " + id + " isn't found");
        }
        return noteRepository.findById(id).get();
    }
}
