package com.asimov.directorservice.client;

import com.asimov.directorservice.model.Teacher;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "teacher-service")
@RequestMapping("api/v1/teachers")
public interface TeacherClient {

    @GetMapping("directors/{directorId}")
    public List<Teacher> getTeachersByDirectorId(@PathVariable Long directorId);

}
