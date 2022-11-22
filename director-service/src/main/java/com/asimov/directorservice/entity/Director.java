package com.asimov.directorservice.entity;

import com.asimov.directorservice.model.Announcement;
import com.asimov.directorservice.model.Teacher;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "directors")
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotEmpty
    private String first_name;

    private int age;

    @NotBlank
    @NotEmpty
    private String email;

    @NotBlank
    @NotEmpty
    private String password;

    @NotNull
    private String phone;

    @Transient
    List<Announcement> announcements;

    @Transient
    List<Teacher> teachers;
}
