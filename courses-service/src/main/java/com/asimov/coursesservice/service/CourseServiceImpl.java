package com.asimov.coursesservice.service;

import com.asimov.coursesservice.client.TeacherClient;
import com.asimov.coursesservice.entity.Competence;
import com.asimov.coursesservice.entity.Course;
import com.asimov.coursesservice.exception.ResourceNotFoundException;
import com.asimov.coursesservice.model.Teacher;
import com.asimov.coursesservice.repository.CompetenceRepository;
import com.asimov.coursesservice.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CompetenceRepository competenceRepository;

    @Autowired
    private TeacherClient teacherClient;

    @Override
    public List<Course> getAllCourse() {
        List<Course> courses = courseRepository.findAll().stream().map(course -> {
            Teacher teacher = teacherClient.getTeacherById(course.getTeacherId());
            course.setTeacher(teacher);
            return course;
        }).collect(Collectors.toList());

        return courses;
    }

    @Override
    public Course getCourseById(Long courseId) {

        Course course = courseRepository.findById(courseId).orElseThrow(()-> new ResourceNotFoundException("Id", courseId));
        if(courseRepository.existsById(courseId)){
            Teacher teacher = teacherClient.getTeacherById(course.getTeacherId());
            course.setTeacher(teacher);
        }

        return course;
    }

    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Long courseId, Course courseResponse) {
        return courseRepository.findById(courseId).map(course -> {
            course.setName(courseResponse.getName());
            course.setState(courseResponse.getState());
            course.setDescription(courseResponse.getDescription());
            course.getCompetences().clear();
            course.setCompetences(courseResponse.getCompetences());
            return courseRepository.save(course);
        }).orElseThrow(()-> new ResourceNotFoundException("Id", courseId));
    }

    @Override
    public ResponseEntity<?> deleteCourse(Long courseId) {
        return courseRepository.findById(courseId).map(course -> {
            courseRepository.delete(course);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException("Id", courseId));
    }

    @Override
    public List<Course> getAllCoursesByTeacherId(Long teacherId) {
        return courseRepository.findByTeacherId(teacherId);
    }

    @Override
    public Course assignCourseCompetence(Long courseId, Long competenceId) {
        Competence competence = competenceRepository.findById(competenceId).orElseThrow(()-> new ResourceNotFoundException("Id", competenceId));

        return courseRepository.findById(courseId).map(course -> courseRepository.save(course.tagWith(competence)))
                .orElseThrow(()-> new ResourceNotFoundException("Id", courseId));
    }

    @Override
    public Course unassignCourseCompetence(Long courseId, Long competenceId) {
        Competence competence = competenceRepository.findById(competenceId).orElseThrow(()-> new ResourceNotFoundException("Id", competenceId));

        return courseRepository.findById(courseId).map(course -> courseRepository.save(course.unTagWith(competence)))
                .orElseThrow(()-> new ResourceNotFoundException("Id", courseId));
    }
}
