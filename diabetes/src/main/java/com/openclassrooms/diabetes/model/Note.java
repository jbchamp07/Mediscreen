package com.openclassrooms.diabetes.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document
@Data
public class Note {

    @Id
    private int id;

    private int patientId;
    private String note;


}
