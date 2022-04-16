package com.example.notes.model;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notes")
@NoArgsConstructor
@Getter
@Setter
public class Note implements Serializable {

    private static final long serialVersionUID = -2343243243242432341L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "noteBody")
    private String noteBody;

    @Column(name = "noteColor")
    private String noteColor;

    public Note(String noteBody, String noteColor) {
        this.noteBody = noteBody;
        this.noteColor = noteColor;
    }
}