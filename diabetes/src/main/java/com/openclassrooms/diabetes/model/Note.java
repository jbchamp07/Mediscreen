package com.openclassrooms.diabetes.model;

import lombok.Data;


/**
 * The type Note.
 */
@Data
public class Note {


    private int id;

    private int patientId;
    private String note;


}
