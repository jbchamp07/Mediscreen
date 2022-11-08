package com.openclassrooms.client.proxies;

import com.openclassrooms.client.beans.NoteBean;
import com.openclassrooms.client.beans.PatientBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The interface Note proxy.
 */
@FeignClient(name = "microservice-note", url = "notes:9002")
public interface NoteProxy {

    /**
     * Gets notes.
     *
     * @param patientId the patient id
     * @return the notes
     */
    @GetMapping(value = "/notes")
    List<NoteBean> getNotes(@RequestParam int patientId);

    /**
     * Add note.
     *
     * @param note the note
     */
    @PostMapping(value = "/notes/add")
    void addNote(@RequestBody NoteBean note);

    /**
     * Update note.
     *
     * @param note the note
     */
    @PutMapping(value = "/notes/update")
    void updateNote(@RequestBody NoteBean note);


    /**
     * Delete note.
     *
     * @param note the note
     */
    @DeleteMapping(value = "/notes/delete")
    void deleteNote(@RequestBody NoteBean note);


    /**
     * Update note by id note bean.
     *
     * @param id the id
     * @return the note bean
     */
    @GetMapping(value = "/note/update")
    NoteBean updateNoteById(@RequestParam int id);

    /**
     * Delete note by id note bean.
     *
     * @param id the id
     * @return the note bean
     */
    @GetMapping(value = "/note/delete")
    NoteBean deleteNoteById(@RequestParam int id);
}
