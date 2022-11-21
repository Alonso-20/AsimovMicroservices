package com.asimov.coursesservice.service;

import com.asimov.coursesservice.entity.Competence;
import com.asimov.coursesservice.entity.Course;
import com.asimov.coursesservice.exception.ResourceNotFoundException;
import com.asimov.coursesservice.repository.CompetenceRepository;
import com.asimov.coursesservice.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CompetenceRepository competenceRepository;

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long courseId) {
        return courseRepository.findById(courseId).orElseThrow(()-> new ResourceNotFoundException("Id", courseId));
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
