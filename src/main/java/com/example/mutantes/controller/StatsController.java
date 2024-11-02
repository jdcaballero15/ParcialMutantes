package com.example.mutantes.controller;

import com.example.mutantes.repository.DnaRepository;
import com.example.mutantes.service.StatsService;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.mutantes.dto.StatsResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.mutantes.service.StatsService;


@RestController
@RequestMapping("/stats")
public class StatsController {

    //private final DnaRepository repository;
    private final StatsService statsService;

    public StatsController(StatsService statsService) {
        this.statsService = statsService;
    }
    @GetMapping("/")
    public StatsResponse getStats() {

        return statsService.getStats();
    }

}
