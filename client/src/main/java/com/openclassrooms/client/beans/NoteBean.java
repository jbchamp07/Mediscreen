package com.openclassrooms.client.beans;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

@Data
public class NoteBean {

    private int id;
    private int patientId;
    private String note;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String date;

}
