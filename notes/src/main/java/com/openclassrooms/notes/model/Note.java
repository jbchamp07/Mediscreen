package com.openclassrooms.notes.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * The type Note.
 */
@Data
@Document
public class Note {

    @Id
    private int id;
    private int patientId;
    private String note;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String date;

}
