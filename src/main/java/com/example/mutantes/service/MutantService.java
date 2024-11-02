package com.example.mutantes.service;

import com.example.mutantes.dto.StatsResponse;
import com.example.mutantes.model.Dna;
import com.example.mutantes.repository.DnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MutantService {

    @Autowired
    private DnaRepository dnaRepository;

    public boolean isMutant(String[] dna) {
        int n = dna.length;
        int count = 0;

        // Verificar secuencias horizontales
        for (String row : dna) {
            count += countSequences(row);
        }

        // Verificar secuencias verticales
        for (int col = 0; col < n; col++) {
            StringBuilder column = new StringBuilder();
            for (String row : dna) {
                column.append(row.charAt(col));
            }
            count += countSequences(column.toString());
        }

        // Verificar secuencias oblicuas (diagonal principal)
        for (int i = 0; i <= n - 4; i++) {
            StringBuilder diagonal = new StringBuilder();
            for (int j = 0; j <= n - 4; j++) {
                diagonal.append(dna[i + j].charAt(j));
            }
            count += countSequences(diagonal.toString());
        }

        // Verificar secuencias oblicuas (diagonal secundaria)
        for (int i = 0; i <= n - 4; i++) {
            StringBuilder diagonal = new StringBuilder();
            for (int j = 0; j <= n - 4; j++) {
                diagonal.append(dna[i + j].charAt(n - 1 - j));
            }
            count += countSequences(diagonal.toString());
        }

        boolean isMutant = count > 1;
        if (isMutant) {
            dnaRepository.save(new Dna(dna, true));
        } else {
            dnaRepository.save(new Dna(dna, false));
        }

        return isMutant;
    }

    private int countSequences(String sequence) {
        int count = 0;
        for (int i = 0; i <= sequence.length() - 4; i++) {
            String subSequence = sequence.substring(i, i + 4);
            if (subSequence.equals("AAAA") || subSequence.equals("TTTT") ||
                    subSequence.equals("CCCC") || subSequence.equals("GGGG")) {
                count++;
            }
        }
        return count;
    }

    public StatsResponse getStats() {
        long countMutantDna = dnaRepository.countByIsMutant(true);
        long countHumanDna = dnaRepository.countByIsMutant(false);
        double ratio = countHumanDna > 0 ? (double) countMutantDna / countHumanDna : 0;
        return new StatsResponse(countMutantDna, countHumanDna, ratio);
    }
}

