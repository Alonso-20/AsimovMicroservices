package com.asimov.teacherservice.model;

import lombok.Data;

@Data
public class Item {
    private Long id;

    private String name;

    private String description;

    private boolean state;
}
