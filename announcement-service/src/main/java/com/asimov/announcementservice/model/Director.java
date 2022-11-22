package com.asimov.announcementservice.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class Director {
    private Long id;

    private String first_name;

    private int age;

    private String email;

    private String password;

    private String phone;
}
