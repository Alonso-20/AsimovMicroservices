package com.asimov.announcementservice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Director {
    private Long id;

    private String first_name;

    private int age;

    private String email;

    private String password;

    private String phone;
}
