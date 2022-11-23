package com.asimov.coursesservice.resources.mapper;

import com.asimov.coursesservice.entity.Course;
import com.asimov.coursesservice.resources.CourseDto;
import org.springframework.stereotype.Component;

@Component
public class CourseDtoMapper {
    public Course mapFrom(CourseDto dto){
        return Course.builder().name(dto.getName())
                .description(dto.getDescription())
                .state(dto.getState())
                .items(dto.getItems())
                .teacherId(dto.getTeacherId()).build();
    }
}
