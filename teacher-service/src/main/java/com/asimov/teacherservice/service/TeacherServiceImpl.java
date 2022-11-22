package com.asimov.teacherservice.service;

import com.asimov.teacherservice.client.DirectorClient;
import com.asimov.teacherservice.entity.Teacher;
import com.asimov.teacherservice.exception.ResourceNotFoundException;
import com.asimov.teacherservice.model.Director;
import com.asimov.teacherservice.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private DirectorClient directorClient;

    @Override
    public List<Teacher> getAllTeachers() {

        List<Teacher> teachers = teacherRepository.findAll().stream().map(teacher -> {
            Director director = directorClient.getDirectorById(teacher.getDirectorId());
            teacher.setDirector(director);
            return teacher;
        }).collect(Collectors.toList());

        return teachers;
    }

    @Override
    public Teacher getTeacherById(Long teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(()-> new ResourceNotFoundException("Id", teacherId));
        if(teacherRepository.existsById(teacherId)){
            Director director = directorClient.getDirectorById(teacher.getDirectorId());
            teacher.setDirector(director);
        }
        return teacher;
    }

    @Override
    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher updateTeacher(Long teacherId, Teacher teacherResponse) {
        return teacherRepository.findById(teacherId)
                .map(teacher -> {
                    teacher.setFirst_name(teacherResponse.getFirst_name());
                    teacher.setLast_name(teacherResponse.getLast_name());
                    teacher.setPoint(teacherResponse.getPoint());
                    teacher.setAge(teacherResponse.getAge());
                    teacher.setPassword(teacherResponse.getPassword());
                    teacher.setPhone(teacherResponse.getPhone());
                    return teacherRepository.save(teacher);
                }).orElseThrow(()->new ResourceNotFoundException("Id", teacherId));
    }

    @Override
    public ResponseEntity<?> deleteTeacher(Long teacherId) {
        return teacherRepository.findById(teacherId).map(teacher -> {
            teacherRepository.delete(teacher);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException("Id", teacherId));
    }
}
