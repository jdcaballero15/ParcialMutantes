package com.example.mutantes.controller;

import com.example.mutantes.dto.DnaRequest;
import com.example.mutantes.service.MutantService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MutantController.class)
public class MutantControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MutantService mutantService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testIsMutant() throws Exception {
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        DnaRequest dnaRequest = new DnaRequest();
        dnaRequest.setDna(dna);

        when(mutantService.isMutant(dna)).thenReturn(true);

        mockMvc.perform(post("/mutant")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dnaRequest)))
                .andExpect(status().isOk());
    }

    @Test
    public void testIsNotMutant() throws Exception {
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCTTA","TCACTG"};
        DnaRequest dnaRequest = new DnaRequest();
        dnaRequest.setDna(dna);

        when(mutantService.isMutant(dna)).thenReturn(false);

        mockMvc.perform(post("/mutant")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dnaRequest)))
                .andExpect(status().isForbidden());
    }
}
