package com.asimov.directorservice.service;

import com.asimov.directorservice.entity.Director;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DirectorService  {
    List<Director> getAll();
    Director getByDirectorId(Long directorId);
    Director createDirector(Director director);
    Director updateDirectorById(Long directorId, Director directorRequest);
    ResponseEntity<?> deleteDirector(Long directorId);
}
