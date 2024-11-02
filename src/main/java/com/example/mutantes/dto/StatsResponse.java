package com.example.mutantes.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

public class StatsResponse {

    @JsonProperty("countMutantDna")
    private long countMutantDna;
    @JsonProperty("countHumanDna")
    private long countHumanDna;
    private double ratio;


}

