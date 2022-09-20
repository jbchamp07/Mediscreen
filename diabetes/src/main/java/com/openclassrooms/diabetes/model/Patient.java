package com.openclassrooms.diabetes.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


@Data
public class Patient {

    private int id;
    private String family;
    private String given;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String dob;
    private String address;
    private String phone;
    private String sex;

}
