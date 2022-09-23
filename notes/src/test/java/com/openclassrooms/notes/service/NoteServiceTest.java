package com.openclassrooms.notes.service;

import com.openclassrooms.notes.model.Note;
import com.openclassrooms.notes.repository.NoteRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NoteServiceTest {

    @InjectMocks
    private NoteService noteService;
    @Mock
    private NoteRepository noteRepository;
    private Note note;

    @BeforeAll
    public void start(){
        note = new Note();
        note.setId(1);
        note.setNote("noteTest");
        note.setDate("01-01-2000");
        note.setPatientId(2);
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getNextSequenceTest(){

    }

    @Test
    public void saveNoteTest(){
        //TODO
        List<Note> list = new ArrayList<>();
        list.add(note);

        when(noteRepository.save(note)).thenReturn(note);
        noteService.saveNote(note);
        when(noteRepository.findByPatientId(2)).thenReturn(list);
        assertEquals("noteTest",noteService.noteById(note.getPatientId()).get(0).getNote());


    }

    @Test
    public void updateNoteTest(){

        List<Note> list = new ArrayList<>();
        list.add(note);

        when(noteRepository.save(note)).thenReturn(note);
        noteService.updateNote(note);
        when(noteRepository.findByPatientId(2)).thenReturn(list);
        assertEquals("noteTest",noteService.noteById(note.getPatientId()).get(0).getNote());
    }


    @Test
    public void noteByIdTest(){

        List<Note> list = new ArrayList<>();
        list.add(note);

        when(noteRepository.findByPatientId(2)).thenReturn(list);
        assertEquals("noteTest",noteService.noteById(note.getPatientId()).get(0).getNote());
    }

    @Test
    public void deleteNoteTest(){

        noteService.deleteNote(note);
        verify(noteRepository,times(1)).delete(note);

    }


    @Test
    public void getANoteTest(){

        when(noteRepository.findById(note.getId())).thenReturn(java.util.Optional.ofNullable(note));
        noteService.getANote(note.getId());
        assertEquals("noteTest",noteService.getANote(note.getId()).getNote());

    }

}
