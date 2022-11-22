package com.asimov.teacherservice.model;

import lombok.Data;

import java.util.List;

@Data
public class Course {

    private Long id;

    private String name;

    private String description;

    private Boolean state;

    private List<Competence> competences;

    private List<Item> items;

}
