package com.example.SpringRest.Services;

import com.example.SpringRest.Dao.CourseDao;
import com.example.SpringRest.Entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Course> getCourses() {
        return courseDao.findAll();
    }
    @Override
    public Course getCourse(long courseId){


        return courseDao.getReferenceById(courseId);
    }

    @Override
    public Course addCourse(Course course) {

        courseDao.save(course);

        return course;
    }
    @Override
    public Course update(Course co){
        courseDao.save(co);

        return co;
    }

    @Override
    public ResponseEntity<HttpStatus> deleteCourse(long courseId) {
        ResponseEntity<HttpStatus> st = null;

        if(courseDao.existsById(courseId)){
            Course entity = courseDao.getReferenceById(courseId);
            courseDao.delete(entity);
            st = new ResponseEntity<>(HttpStatus.OK);

        }

        return st;
    }


}
