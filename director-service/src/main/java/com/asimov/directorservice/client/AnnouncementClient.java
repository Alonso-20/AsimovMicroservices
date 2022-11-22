package com.asimov.directorservice.client;

import com.asimov.directorservice.model.Announcement;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "announcement-service")
@RequestMapping("api/v1/announcements")
public interface AnnouncementClient {
    @GetMapping("directors/{directorId}")
    List<Announcement> getAnnouncementByDirectorsId(@PathVariable Long directorId);
}
