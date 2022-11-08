package com.openclassrooms.notes.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The type Custom sequences.
 */
@Document(collection = "customSequences")
@Data
public class CustomSequences {

    @Id
    private String id;
    private int seq;

}
