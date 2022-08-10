package com.example.SpringRest.Services;

import com.example.SpringRest.Entities.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{
    List<Course> list;


    public CourseServiceImpl() {
        this.list = new ArrayList<>();
        list.add(new Course(110,"Introduction to Spring","This course contains basics of Spring"));
        list.add(new Course(120,"Spring Boot ","Detailed Spring boot"));
        list.add(new Course(130,"My History","Story of Soloman"));
    }

    @Override
    public List<Course> getCourses() {
        return list;
    }
    @Override
    public Course getCourse(long courseId){
        Course c = null;
        for (Course course:list){
            if (course.getId()==courseId){
                c = course;
                break;
            }

        }
        return c;
    }

    @Override
    public Course addCourse(Course course) {
        list.add(course);
        return course;
    }
    @Override
    public Course update(Course co){
        Course c = null;
        int i = 0;
        for (Course course:list){
            if (course.getId()==co.getId()){
                c = co;
                Course k = list.remove(i);
                list.add(co);
                break;
            }
            i++;

        }
        return c;
    }

    @Override
    public Course delete(long courseId) {
        Course c = null;
        int i = 0;
        for (Course course:list){
            if (course.getId()==courseId){
                c = list.remove(i);


                break;
            }
            i++;

        }
        return c;
    }


}
