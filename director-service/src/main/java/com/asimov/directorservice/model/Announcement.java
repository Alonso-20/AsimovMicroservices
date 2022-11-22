package com.asimov.directorservice.model;

import lombok.Data;

@Data
public class Announcement {
    private Long id;

    private String title;

    private String description;
}
