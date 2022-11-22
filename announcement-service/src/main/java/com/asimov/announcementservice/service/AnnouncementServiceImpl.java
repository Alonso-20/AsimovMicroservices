package com.asimov.announcementservice.service;

import com.asimov.announcementservice.entity.Announcement;
import com.asimov.announcementservice.exception.ResourceNotFoundException;
import com.asimov.announcementservice.repository.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    @Autowired
    private AnnouncementRepository announcementRepository;

    @Override
    public List<Announcement> getAllAnnouncement() {
        return announcementRepository.findAll();
    }

    @Override
    public Announcement getAnnouncementById(Long announcementId) {
        return announcementRepository.findById(announcementId).orElseThrow(()->new ResourceNotFoundException("Id", announcementId));
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
}
