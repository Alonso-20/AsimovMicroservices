package com.asimov.coursesservice.controller;

import com.asimov.coursesservice.entity.Course;
import com.asimov.coursesservice.resources.CourseDto;
import com.asimov.coursesservice.resources.mapper.CourseDtoMapper;
import com.asimov.coursesservice.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    private CourseDtoMapper courseDtoMapper;

    public CourseController(CourseDtoMapper courseDtoMapper){
        this.courseDtoMapper = courseDtoMapper;
    }

    @GetMapping
    public List<Course> getAllCourses(){
        return courseService.getAllCourse();
    }

    @GetMapping("{courseId}")
    public Course getCourseById(@PathVariable("courseId") Long courseId){
        return courseService.getCourseById(courseId);
    }

    @GetMapping("teacher/{teacherId}")
    public List<Course> getAllCoursesByTeacherId(@PathVariable Long teacherId){
        return courseService.getAllCoursesByTeacherId(teacherId);
    }

    @PostMapping
    public Course createCourse(@Valid @RequestBody CourseDto course){
        return courseService.createCourse(courseDtoMapper.mapFrom(course));
    }


    @PutMapping("{courseId}")
    public Course updateCourse(@PathVariable("courseId") Long courseId,@Valid @RequestBody CourseDto course) {
        return courseService.updateCourse(courseId,courseDtoMapper.mapFrom(course));
    }

    @DeleteMapping("{courseId}")
    public ResponseEntity<?> deleteCourse(@PathVariable("courseId") Long courseId){
        return courseService.deleteCourse(courseId);
    }

    @PostMapping("{courseId}/competences/{competenceId}")
    public Course assignCompetence(@PathVariable Long courseId, @PathVariable Long competenceId){
        return courseService.assignCourseCompetence(courseId,competenceId);
    }


    @DeleteMapping("{courseId}/competences/{competenceId}")
    public Course unassignCompetence(@PathVariable Long courseId, @PathVariable Long competenceId){
        return courseService.unassignCourseCompetence(courseId,competenceId);
    }

}
