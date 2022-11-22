package com.asimov.teacherservice.service;

import com.asimov.teacherservice.entity.Teacher;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TeacherService {
    List<Teacher> getAllTeachers();
    List<Teacher> getTeachersByDirectorId(Long directorId);
    Teacher getTeacherById(Long teacherId);
    Teacher createTeacher(Teacher teacher);
    Teacher updateTeacher(Long teacherId, Teacher teacherResponse);
    ResponseEntity<?> deleteTeacher(Long teacherId);
}
