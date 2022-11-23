package com.asimov.coursesservice.controller;

import com.asimov.coursesservice.entity.Competence;
import com.asimov.coursesservice.resources.CompetenceDto;
import com.asimov.coursesservice.resources.mapper.CompetenceDtoMapper;
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

    private CompetenceDtoMapper competenceDtoMapper;

    public CompetenceController(CompetenceDtoMapper competenceDtoMapper){
        this.competenceDtoMapper = competenceDtoMapper;
    }

    @GetMapping
    public List<Competence> getAllCompetences() {
        return competenceService.getAllCompetences();
    }

    @GetMapping("{competenceId}")
    public Competence getCompetenceById(@PathVariable("competenceId") Long competenceId) {
        return competenceService.getCompetenceById(competenceId);
    }

    @PostMapping
    public Competence createCompetence(@Valid @RequestBody CompetenceDto competence) {
        return competenceService.createCompetence(competenceDtoMapper.mapFrom(competence));
    }

    @PutMapping("{competenceId}")
    public Competence updateCompetence(@PathVariable("competenceId") Long competenceId,@Valid @RequestBody CompetenceDto competence) {
        return competenceService.updateCompetence(competenceId, competenceDtoMapper.mapFrom(competence));
    }

    @DeleteMapping("{competenceId}")
    public ResponseEntity<?> deleteCompetence(@PathVariable("competenceId") Long competenceId){
        return competenceService.deleteCompetence(competenceId);
    }
}