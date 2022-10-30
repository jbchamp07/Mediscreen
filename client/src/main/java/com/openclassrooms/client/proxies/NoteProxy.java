package com.openclassrooms.client.proxies;

import com.openclassrooms.client.beans.NoteBean;
import com.openclassrooms.client.beans.PatientBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "microservice-note", url = "notes:9002")
public interface NoteProxy {

    @GetMapping(value = "/notes")
    List<NoteBean> getNotes(@RequestParam int patientId);

    @PostMapping(value = "/notes/add")
    void addNote(@RequestBody NoteBean note);

    @PutMapping(value = "/notes/update")
    void updateNote(@RequestBody NoteBean note);


    @DeleteMapping(value = "/notes/delete")
    void deleteNote(@RequestBody NoteBean note);


    @GetMapping(value = "/note/update")
    NoteBean updateNoteById(@RequestParam int id);

    @GetMapping(value = "/note/delete")
    NoteBean deleteNoteById(@RequestParam int id);
}
