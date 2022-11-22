package com.asimov.announcementservice.service;

import com.asimov.announcementservice.entity.Announcement;
import com.asimov.announcementservice.model.Director;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AnnouncementService {
    List<Announcement> getAllAnnouncement();
    Announcement getAnnouncementById(Long announcementId);
    Announcement createAnnouncement(Announcement announcement);
    Announcement updateAnnouncement(Long announcementId, Announcement announcementResponse);
    ResponseEntity<?> deleteAnnouncement(Long announcementId);
    List<Announcement> getAllAnnouncementByDirectorId(Long directorId);
}
