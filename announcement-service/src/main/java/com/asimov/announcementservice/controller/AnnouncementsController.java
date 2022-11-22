package com.asimov.announcementservice.controller;

import com.asimov.announcementservice.entity.Announcement;
import com.asimov.announcementservice.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/announcements")
public class AnnouncementsController {

    @Autowired
    private AnnouncementService announcementService;

    @GetMapping
    public List<Announcement> getAllAnnouncement(){
        return announcementService.getAllAnnouncement();
    }

    @GetMapping("{announcementId}")
    public Announcement getAnnouncementById(@PathVariable Long announcementId){
        return announcementService.getAnnouncementById(announcementId);
    }

    @PostMapping
    public Announcement createAnnouncement(@Valid @RequestBody Announcement announcement){
        return announcementService.createAnnouncement(announcement);
    }

    @PutMapping("{announcementId}")
    public Announcement updateAnnouncement(@PathVariable Long announcementId, @Valid @RequestBody Announcement announcement){
        return announcementService.updateAnnouncement(announcementId, announcement);
    }

    @DeleteMapping("{announcementId}")
    public ResponseEntity<?> deleteAnnouncement(@PathVariable Long announcementId){
        return announcementService.deleteAnnouncement(announcementId);
    }
}
