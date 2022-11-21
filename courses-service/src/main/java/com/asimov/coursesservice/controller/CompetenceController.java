package com.asimov.coursesservice.controller;

import com.asimov.coursesservice.entity.Competence;
import com.asimov.coursesservice.service.CompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/competences")
public class CompetenceController {
    @Autowired
    private CompetenceService competenceService;

    @GetMapping
    public List<Competence> getAllCompetences() {
        return competenceService.getAllCompetences();
    }

    @GetMapping("{competenceId}")
    public Competence getCompetenceById(@PathVariable("competenceId") Long competenceId) {
        return competenceService.getCompetenceById(competenceId);
    }

    @PostMapping
    public Competence createCompetence(@Valid @RequestBody Competence competence) {
        return competenceService.createCompetence(competence);
    }

    @PutMapping("{competenceId}")
    public Competence updateCompetence(@PathVariable("competenceId") Long competenceId,@Valid @RequestBody Competence competence) {
        return competenceService.updateCompetence(competenceId, competence);
    }

    @DeleteMapping("{competenceId}")
    public ResponseEntity<?> deleteCompetence(@PathVariable("competenceId") Long competenceId){
        return competenceService.deleteCompetence(competenceId);
    }
}