package com.openclassrooms.notes.service;

import com.openclassrooms.notes.model.CustomSequences;
import com.openclassrooms.notes.model.Note;
import com.openclassrooms.notes.repository.NoteRepository;
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

@Service
public class NoteService {


    private MongoOperations mongoOperations;

    public NoteService(MongoOperations mongoOperations){
        this.mongoOperations = mongoOperations;
    }

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

    public void saveNote(Note note){
        note.setDate(Date.from(Instant.now()).toString());

        note.setId(getNextSequence("customSequences"));

        noteRepository.save(note);
    }

    public void updateNote(Note note){
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
