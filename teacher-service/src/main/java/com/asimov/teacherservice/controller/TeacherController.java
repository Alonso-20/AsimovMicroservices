package com.asimov.teacherservice.controller;

import com.asimov.teacherservice.entity.Teacher;
import com.asimov.teacherservice.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/teachers")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public List<Teacher> getAllTeachers(){
        return teacherService.getAllTeachers();
    }

    @GetMapping("directors/{directorId}")
    public List<Teacher> getTeachersByDirectorId(@PathVariable Long directorId){
        return teacherService.getTeachersByDirectorId(directorId);
    }

    @GetMapping("{teacherId}")
    public Teacher getTeacherById(@PathVariable("teacherId") Long teacherId){
        return teacherService.getTeacherById(teacherId);
    }

    @PostMapping
    public Teacher createTeacher(@Valid @RequestBody Teacher teacher){
        return teacherService.createTeacher(teacher);
    }

    @PutMapping("{teacherId}")
    public Teacher updateTeacher(@PathVariable("teacherId") Long teacherId ,@Valid @RequestBody Teacher teacher){
        return teacherService.updateTeacher(teacherId, teacher);
    }

    @DeleteMapping("{teacherId}")
    public ResponseEntity<?> deleteTeacher(@PathVariable("teacherId") Long teacherId){
        return teacherService.deleteTeacher(teacherId);
    }
}
