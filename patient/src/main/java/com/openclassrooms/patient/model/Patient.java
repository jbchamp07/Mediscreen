package com.openclassrooms.patient.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Patient {

    @Id
    private int id;
    private String family;
    private String given;
    private Date dob;
    private String address;
    private String phone;
    private String sex;

}
