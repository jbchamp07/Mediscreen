package com.openclassrooms.notes.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document
public class Note {

    @Id
    private int id;
    private int patientId;
    private String note;

}
