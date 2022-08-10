package com.example.SpringRest.Dao;

import com.example.SpringRest.Entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface CourseDao extends JpaRepository<Course,Long> {
    //Class Course , primary key datatype long

}
