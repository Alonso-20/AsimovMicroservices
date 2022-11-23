package com.asimov.coursesservice.resources;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CompetenceDto {

    @NotEmpty
    private String title;

    @NotEmpty
    private String description;
}
