package com.asimov.coursesservice.service;

import com.asimov.coursesservice.entity.Competence;
import com.asimov.coursesservice.exception.ResourceNotFoundException;
import com.asimov.coursesservice.repository.CompetenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetenceServiceImpl implements CompetenceService{

    @Autowired
    private CompetenceRepository competenceRepository;

    @Override
    public List<Competence> getAllCompetences() {
        return competenceRepository.findAll();
    }

    @Override
    public Competence createCompetence(Competence competence) {
        return competenceRepository.save(competence);
    }

    @Override
    public Competence getCompetenceById(Long competenceId) {
        return competenceRepository.findById(competenceId).orElseThrow(()-> new ResourceNotFoundException("Id", competenceId));
    }

    @Override
    public Competence updateCompetence(Long competenceId, Competence competenceResponse) {
        return competenceRepository.findById(competenceId).map(competence -> {
            competence.setTitle(competenceResponse.getTitle());
            competence.setDescription(competenceResponse.getDescription());
            return competenceRepository.save(competence);
        }).orElseThrow(()-> new ResourceNotFoundException("Id", competenceId));
    }

    @Override
    public ResponseEntity<?> deleteCompetence(Long competenceId) {
        return competenceRepository.findById(competenceId).map(competence -> {
            competenceRepository.delete(competence);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException("Id", competenceId));
    }
}
