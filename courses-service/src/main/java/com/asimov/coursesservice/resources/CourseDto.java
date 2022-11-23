package com.asimov.coursesservice.resources;

import com.asimov.coursesservice.entity.Competence;
import com.asimov.coursesservice.entity.Item;
import com.asimov.coursesservice.model.Teacher;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Data
public class CourseDto {

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    private Boolean state;

    private List<Item> items;

    private Long teacherId;

    public CourseDto(){
        items = new ArrayList<>();
    }
}
