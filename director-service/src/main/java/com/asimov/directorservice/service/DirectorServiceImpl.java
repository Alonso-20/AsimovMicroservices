package com.asimov.directorservice.service;

import com.asimov.directorservice.client.AnnouncementClient;
import com.asimov.directorservice.entity.Director;
import com.asimov.directorservice.exception.ResourceNotFoundException;
import com.asimov.directorservice.model.Announcement;
import com.asimov.directorservice.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DirectorServiceImpl implements DirectorService{

    @Autowired
    private DirectorRepository directorRepository;

    @Autowired
    private AnnouncementClient announcementClient;

    @Override
    public List<Director> getAll() {

        List<Director> directors = directorRepository.findAll().stream().map(director -> {
            List<Announcement> announcements = announcementClient.getAnnouncementByDirectorsId(director.getId());
            director.setAnnouncements(announcements);
            return director;
        }).collect(Collectors.toList());

        return directors;
    }

    @Override
    public Director getByDirectorId(Long directorId) {

        Director director = directorRepository.findById(directorId).orElseThrow(()-> new ResourceNotFoundException("Director", directorId));
        if(directorRepository.existsById(directorId)){
            List<Announcement> announcements = announcementClient.getAnnouncementByDirectorsId(director.getId());
            director.setAnnouncements(announcements);
        }

        return director;
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
