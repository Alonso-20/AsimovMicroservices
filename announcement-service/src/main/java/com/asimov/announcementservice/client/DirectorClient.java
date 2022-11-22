package com.asimov.announcementservice.client;

import com.asimov.announcementservice.model.Director;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "director-service",fallback = DirectorHystrixFallbackFactory.class)
public interface DirectorClient {
    @GetMapping("api/v1/directors/{directorId}")
    Director getDirectorById(@PathVariable("directorId") Long directorId);
}
