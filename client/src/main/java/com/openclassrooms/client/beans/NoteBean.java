package com.openclassrooms.client.beans;

import lombok.Data;

import java.util.Date;

@Data
public class NoteBean {

    private int id;
    private int patientId;
    private String note;
    private Date date;

}
