package com.asimov.directorservice.service;

import com.asimov.directorservice.entity.Director;
import com.asimov.directorservice.exception.ResourceNotFoundException;
import com.asimov.directorservice.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorServiceImpl implements DirectorService{

    @Autowired
    private DirectorRepository directorRepository;

    @Override
    public List<Director> getAll() {
        return directorRepository.findAll();
    }

    @Override
    public Director getByDirectorId(Long directorId) {
        return directorRepository.findById(directorId).orElseThrow(()-> new ResourceNotFoundException("Director", directorId));
    }

    @Override
    public Director createDirector(Director director) {
        return directorRepository.save(director);
    }

    @Override
    public Director updateDirectorById(Long directorId, Director directorRequest) {
        return directorRepository.findById(directorId).map(director -> {
            director.setFirst_name(directorRequest.getFirst_name());
            director.setEmail(directorRequest.getEmail());
            director.setAge(directorRequest.getAge());
            director.setPassword(directorRequest.getPassword());
            director.setPhone(directorRequest.getPhone());
            return directorRepository.save(director);
        }).orElseThrow(()-> new ResourceNotFoundException("ID", directorId));
    }

    @Override
    public ResponseEntity<?> deleteDirector(Long directorId) {
        return directorRepository.findById(directorId).map(director -> {
            directorRepository.delete(director);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException("ID", directorId));
    }
}
