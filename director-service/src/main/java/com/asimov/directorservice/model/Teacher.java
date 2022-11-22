package com.asimov.directorservice.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class Teacher {
    private Long id;

    private int point;

    private String first_name;

    private String last_name;

    private int age;

    private String password;

    private String phone;
}
