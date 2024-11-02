package com.example.mutantes.controller;

import com.example.mutantes.dto.DnaRequest;
import com.example.mutantes.dto.StatsResponse;
import com.example.mutantes.service.MutantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mutant")
public class MutantController {

    @Autowired
    private MutantService mutantService;

    @PostMapping("/")
    public ResponseEntity<String> isMutant(@RequestBody DnaRequest dnaRequest) {
        boolean isMutant = mutantService.isMutant(dnaRequest.getDna());
        if (isMutant) {
            return new ResponseEntity<>("Mutant detected",HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/stats")
    public ResponseEntity<StatsResponse> getStats() {
        StatsResponse stats = mutantService.getStats();
        return new ResponseEntity<>(stats, HttpStatus.OK);
    }
}

