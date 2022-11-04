package com.openclassrooms.patient.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Patient {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    private String family;
    private String given;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String dob;
    private String address;
    private String phone;
    private String sex;

}
