package com.example.SpringRest.Controller;
import com.example.SpringRest.Entities.Course;
import com.example.SpringRest.Services.CourseService;
import com.example.SpringRest.Services.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {
    //Request will come to controller first
    //REST -> Representational State Transfer
    @Autowired
    private CourseService courseService;
    @GetMapping("/courses")
    public List<Course> getCourses(){

        return this.courseService.getCourses();
    }
    @GetMapping("/courses/{courseId}")//course id dynamic
    public Course getCourse(@PathVariable String courseId){

        return this.courseService.getCourse(Long.parseLong(courseId));
    }
    @PostMapping(path="/courses" ,consumes = "application/json")
    public Course addCourse(@RequestBody Course course){
        return this.courseService.addCourse(course);

    }
    @PutMapping(path = "/courses",consumes = "application/json")
    public Course update (@RequestBody Course course){
        return this.courseService.update(course);

    }
    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
        try{
            return this.courseService.deleteCourse(Long.parseLong(courseId));

        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }


}
