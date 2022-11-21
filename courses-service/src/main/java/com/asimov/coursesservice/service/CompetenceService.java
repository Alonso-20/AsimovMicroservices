package com.asimov.coursesservice.service;

import com.asimov.coursesservice.entity.Competence;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CompetenceService {
    List<Competence> getAllCompetences();
    Competence createCompetence(Competence competence);
    Competence getCompetenceById(Long competenceId);
    Competence updateCompetence(Long competenceId, Competence competenceResponse);
    ResponseEntity<?> deleteCompetence(Long competenceId);
}
