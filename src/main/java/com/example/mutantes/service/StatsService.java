package com.example.mutantes.service;

import com.example.mutantes.repository.DnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.mutantes.dto.StatsResponse;

@Service
public class StatsService {

    private final DnaRepository repository;

    @Autowired
    public StatsService(DnaRepository repository) {
        this.repository = repository;
    }

    public StatsResponse getStats() {
        long countMutantDna = repository.countByIsMutant(true);
        long countHumanDna = repository.countByIsMutant(false);

        // Cálculo del ratio, evitando división por cero
        double ratio = (countHumanDna == 0) ? 0 : (double) countMutantDna / countHumanDna;

        // Retornar el objeto con las estadísticas
        return new StatsResponse(countMutantDna, countHumanDna, ratio);
    }

}
