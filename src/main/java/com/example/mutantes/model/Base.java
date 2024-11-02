package com.example.mutantes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import java.io.Serializable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;


@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@MappedSuperclass
@Data

public class Base implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
}
