package com.asimov.teacherservice.model;

import lombok.Data;

@Data
public class Director {
    private Long id;

    private String first_name;

    private int age;

    private String email;

    private String password;

    private String phone;
}
