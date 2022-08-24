package com.openclassrooms.client.proxies;

import com.openclassrooms.client.beans.NoteBean;
import com.openclassrooms.client.beans.PatientBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "microservice-note", url = "localhost:9002")
public interface NoteProxy {

    @GetMapping(value = "/notes")
    List<NoteBean> getNotes();

    @PostMapping(value = "/note/add")
    void addNote(@RequestBody NoteBean patient);

    @PutMapping(value = "/note/update")
    void updateNote(@RequestBody NoteBean patient);

    //TODO
    @DeleteMapping(value = "/note/delete")
    void deleteNote(@RequestParam int patientId);

    //TODO
    @GetMapping(value = "/note/update")
    NoteBean getNote(@RequestParam int patientId);

    @GetMapping(value = "/note/delete")
    NoteBean getNoteId(int id);
}
