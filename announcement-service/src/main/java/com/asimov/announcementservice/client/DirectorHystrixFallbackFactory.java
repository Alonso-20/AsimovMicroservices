package com.asimov.announcementservice.client;

import com.asimov.announcementservice.model.Director;

public class DirectorHystrixFallbackFactory implements DirectorClient{
    @Override
    public Director getDirectorById(Long directorId) {

        return Director.builder()
                .first_name("none")
                .phone("none")
                .password("none")
                .email("none").build();
    }
}
