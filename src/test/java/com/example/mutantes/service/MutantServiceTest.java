package com.example.mutantes.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class MutantServiceTest {

    @Autowired
    private MutantService mutantService;

    @Test
    public void testIsMutant() {
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        boolean isMutant = mutantService.isMutant(dna);
        assertTrue(isMutant);
    }

    @Test
    public void testIsNotMutant() {
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCTTA","TCACTG"};
        boolean isMutant = mutantService.isMutant(dna);
        assertFalse(isMutant);
    }
}

