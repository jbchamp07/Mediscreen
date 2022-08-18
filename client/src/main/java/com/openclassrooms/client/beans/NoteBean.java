package com.openclassrooms.client.beans;

import lombok.Data;

@Data
public class NoteBean {

    private int id;
    private int patientId;
    private String note;

}
