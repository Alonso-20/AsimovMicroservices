package com.asimov.announcementservice.service;

import com.asimov.announcementservice.client.DirectorClient;
import com.asimov.announcementservice.entity.Announcement;
import com.asimov.announcementservice.exception.ResourceNotFoundException;
import com.asimov.announcementservice.model.Director;
import com.asimov.announcementservice.repository.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    @Autowired
    private AnnouncementRepository announcementRepository;

    @Autowired
    private DirectorClient directorClient;

    @Override
    public List<Announcement> getAllAnnouncement() {
        List<Announcement> announcements = announcementRepository.findAll().stream().map(announcement -> {
            Director director = directorClient.getDirectorById(announcement.getDirectorId());
            announcement.setDirector(director);
            return announcement;
        }).collect(Collectors.toList());

        return announcements;
    }

    @Override
    public Announcement getAnnouncementById(Long announcementId) {
        Announcement announcement =announcementRepository.findById(announcementId).orElseThrow(()->new ResourceNotFoundException("Id", announcementId));
        if(announcementRepository.existsById(announcementId)){
            Director director = directorClient.getDirectorById(announcement.getDirectorId());
            announcement.setDirector(director);
        }

        return announcement;
    }

    @Override
    public Announcement createAnnouncement(Announcement announcement) {
        return announcementRepository.save(announcement);
    }

    @Override
    public Announcement updateAnnouncement(Long announcementId, Announcement announcementResponse) {
        return announcementRepository.findById(announcementId).map(announcement -> {
            announcement.setTitle(announcementResponse.getTitle());
            announcement.setDescription(announcementResponse.getDescription());
            return announcementRepository.save(announcement);
        }).orElseThrow(()->new ResourceNotFoundException("Id", announcementId));
    }

    @Override
    public ResponseEntity<?> deleteAnnouncement(Long announcementId) {
        return announcementRepository.findById(announcementId).map(announcement -> {
            announcementRepository.delete(announcement);
            return ResponseEntity.ok().build();
        }).orElseThrow(()->new ResourceNotFoundException("Id", announcementId));
    }

    @Override
    public List<Announcement> getAllAnnouncementByDirectorId(Long directorId) {
        return announcementRepository.findByDirectorId(directorId);
    }
}
