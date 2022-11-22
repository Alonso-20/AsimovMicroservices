package com.asimov.teacherservice.client;

import com.asimov.teacherservice.model.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "course-service")
@RequestMapping("api/v1/courses")
public interface CourseClient {

    @GetMapping("teacher/{teacherId}")
    public List<Course> getAllCoursesByTeacherId(@PathVariable Long teacherId);
}
