package com.example.mutantes.repository;

import com.example.mutantes.model.Dna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DnaRepository extends JpaRepository<Dna, Long> {
    long countByIsMutant(boolean isMutant);
}
