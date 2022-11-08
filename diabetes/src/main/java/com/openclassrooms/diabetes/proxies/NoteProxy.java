package com.openclassrooms.diabetes.proxies;

import com.openclassrooms.diabetes.model.Note;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    @GetMapping("/notes")
    List<Note> getNotes(@RequestParam int patientId);

}
