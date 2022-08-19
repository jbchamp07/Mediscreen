package com.openclassrooms.client.proxies;

import com.openclassrooms.client.beans.NoteBean;
import com.openclassrooms.client.beans.PatientBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "microservice-note", url = "localhost:9002")
public interface NoteProxy {

    @GetMapping(value = "/note")
    List<NoteBean> NotesList();

    @PostMapping(value = "/note/add")
    void add(@RequestBody NoteBean patient);

    @PutMapping(value = "/note/update")
    void update(@RequestBody NoteBean patient);

    //TODO
    @DeleteMapping(value = "/note/delete")
    void delete(@RequestParam int patientId);

    @GetMapping(value = "/note/update")
    NoteBean getNote(@RequestParam int patientId);

    @GetMapping(value = "/note/delete")
    NoteBean getNoteId(int id);
}
