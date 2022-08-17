package com.openclassrooms.diabetes.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Patient {

    @Id
    private int id;

}
