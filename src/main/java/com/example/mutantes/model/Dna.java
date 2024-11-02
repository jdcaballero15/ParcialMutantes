package com.example.mutantes.model;


import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;




@Entity
public class Dna extends Base implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String[] dna;
    private boolean isMutant;

    public Dna() {
    }

    public Dna(String[] dna, boolean isMutant) {
        this.dna = dna;
        this.isMutant = isMutant;
    }


}
