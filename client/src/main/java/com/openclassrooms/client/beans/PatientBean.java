package com.openclassrooms.client.beans;

import lombok.Data;

import java.util.Date;

@Data
public class PatientBean {
    private int id;
    private String family;
    private String given;
    private Date dob;
    private String address;
    private String phone;
    private String sex;
}
