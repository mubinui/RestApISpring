package com.example.SpringRest.Services;

import com.example.SpringRest.Entities.Course;

import java.util.List;

public interface CourseService {
    public List<Course>getCourses();
    public Course getCourse(long courseId);
    public Course addCourse(Course course);
    public Course update(Course course);
    public Course delete (long courseId);

}
