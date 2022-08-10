package com.example.SpringRest.Services;

import com.example.SpringRest.Entities.Course;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    public List<Course>getCourses();
    public Course getCourse(long courseId);
    public Course addCourse(Course course);
    public Course update(Course course);
    public ResponseEntity<HttpStatus> deleteCourse (long courseId);

}
