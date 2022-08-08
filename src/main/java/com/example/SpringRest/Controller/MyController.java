package com.example.SpringRest.Controller;
import com.example.SpringRest.Entities.Course;
import com.example.SpringRest.Services.CourseService;
import com.example.SpringRest.Services.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {
    //Request will come to controller first
    //REST -> Representational State Transfer
    @Autowired
    private CourseService courseService;
    @GetMapping("/home")
    public String home(){
        return "Mubin's Home";
    }
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


}
