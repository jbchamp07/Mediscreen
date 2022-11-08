package com.openclassrooms.notes.service;

import com.openclassrooms.notes.model.CustomSequences;
import com.openclassrooms.notes.model.Note;
import com.openclassrooms.notes.repository.NoteRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * The type Note service test.
 */
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NoteServiceTest {

    @InjectMocks
    private NoteService noteService;
    @Mock
    private NoteRepository noteRepository;
    @Mock
    private MongoOperations mongoOperations;
    private Note note;

    /**
     * Start.
     */
    @BeforeAll
    public void start(){
        note = new Note();
        note.setId(1);
        note.setNote("noteTest");
        note.setDate("01-01-2000");
        note.setPatientId(2);
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Get next sequence test.
     */
    @Test
    public void getNextSequenceTest(){
        /*CustomSequences counter = new CustomSequences();
        counter.setId("1");
        counter.setSeq(1);
        when(mongoOperations.findAndModify(query(where("_id").is("customSequencesTest")),
                new Update().inc("seq",1),
                options().returnNew(true).upsert(true),
                CustomSequences.class))
                .thenReturn(counter);
        assertEquals(1,noteService.getNextSequence("customSequencesTest"));*/
    }

    /**
     * Save note test.
     */
    @Test
    public void saveNoteTest(){
        //TODO
        /*List<Note> list = new ArrayList<>();
        list.add(note);

        when(noteRepository.save(note)).thenReturn(note);
        noteService.saveNote(note);
        when(noteRepository.findByPatientId(2)).thenReturn(list);
        assertEquals("noteTest",noteService.noteById(note.getPatientId()).get(0).getNote());

*/
    }

    /**
     * Update note test.
     */
    @Test
    public void updateNoteTest(){

        List<Note> list = new ArrayList<>();
        list.add(note);

        when(noteRepository.save(note)).thenReturn(note);
        noteService.updateNote(note);
        when(noteRepository.findByPatientId(2)).thenReturn(list);
        assertEquals("noteTest",noteService.noteById(note.getPatientId()).get(0).getNote());
    }


    /**
     * Note by id test.
     */
    @Test
    public void noteByIdTest(){

        List<Note> list = new ArrayList<>();
        list.add(note);

        when(noteRepository.findByPatientId(2)).thenReturn(list);
        assertEquals("noteTest",noteService.noteById(note.getPatientId()).get(0).getNote());
    }

    /**
     * Delete note test.
     */
    @Test
    public void deleteNoteTest(){

        noteService.deleteNote(note);
        verify(noteRepository,times(1)).delete(note);

    }


    /**
     * Get a note test.
     */
    @Test
    public void getANoteTest(){

        when(noteRepository.findById(note.getId())).thenReturn(java.util.Optional.ofNullable(note));
        noteService.getANote(note.getId());
        assertEquals("noteTest",noteService.getANote(note.getId()).getNote());

    }

}
