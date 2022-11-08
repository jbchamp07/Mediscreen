package com.openclassrooms.client.beans;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * The type Patient bean.
 */
@Data
public class PatientBean {
    private int id;
    private String family;
    private String given;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String dob;
    private String address;
    private String phone;
    private String sex;
}
