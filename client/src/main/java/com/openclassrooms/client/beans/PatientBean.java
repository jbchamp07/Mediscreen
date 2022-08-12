package com.openclassrooms.client.beans;

import lombok.Data;

import java.util.Date;

@Data
public class PatientBean {
    private int id;
    private String lastName;
    private String firstName;
    private Date dateOfBirth;
}
