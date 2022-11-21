package com.asimov.directorservice.controller;

import com.asimov.directorservice.entity.Director;
import com.asimov.directorservice.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/directors")
public class DirectorsController {
    @Autowired
    private DirectorService directorService;

    @GetMapping
    public List<Director> getAllDirectors(){
        return directorService.getAll();
    }

    @GetMapping("{directorId}")
    public Director getDirectorById(@PathVariable("directorId") Long directorId){
        return directorService.getByDirectorId(directorId);
    }

    @PostMapping
    public Director createDirector(@Valid @RequestBody Director director){
        return directorService.createDirector(director);
    }

    @PutMapping("{directorId}")
    public Director updateDirectorById(@PathVariable("directorId") Long directorId, @Valid @RequestBody Director director){
        return directorService.updateDirectorById(directorId, director);
    }

    @DeleteMapping("{directorId}")
    public ResponseEntity<?> deleteDirector(@PathVariable("directorId") Long directorId){
        return directorService.deleteDirector(directorId);
    }
}
