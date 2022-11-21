package com.asimov.coursesservice.service;

import com.asimov.coursesservice.entity.Course;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourse();
    Course getCourseById(Long courseId);
    Course createCourse(Course course);
    Course updateCourse(Long courseId, Course courseResponse);
    ResponseEntity<?> deleteCourse(Long courseId);

    Course assignCourseCompetence(Long courseId, Long competenceId);
    Course unassignCourseCompetence(Long courseId, Long competenceId);

}
