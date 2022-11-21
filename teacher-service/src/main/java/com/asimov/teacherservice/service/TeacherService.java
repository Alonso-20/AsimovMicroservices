package com.asimov.teacherservice.service;

import com.asimov.teacherservice.entity.Teacher;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TeacherService {
    List<Teacher> getAllTeachers();
    Teacher getTeacherById(Long teacherId);
    Teacher createTeacher(Teacher teacher);
    Teacher updateTeacher(Long teacherId, Teacher teacherResponse);
    ResponseEntity<?> deleteTeacher(Long teacherId);
}
