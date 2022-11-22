package com.asimov.coursesservice.client;

import com.asimov.coursesservice.model.Teacher;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "teacher-service")
@RequestMapping("api/v1/teachers")
public interface TeacherClient {
    @GetMapping("{teacherId}")
    Teacher getTeacherById(@PathVariable("teacherId") Long teacherId);
}
