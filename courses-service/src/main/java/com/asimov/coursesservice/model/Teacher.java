package com.asimov.coursesservice.model;

import lombok.Data;

@Data
public class Teacher {
    private Long id;

    private int point;

    private String first_name;

    private String last_name;

    private int age;

    private String password;

    private String phone;

    private Long directorId;
}
