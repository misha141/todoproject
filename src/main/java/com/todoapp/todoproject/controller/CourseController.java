package com.todoapp.todoproject.controller;

import com.todoapp.todoproject.entity.Course;
import com.todoapp.todoproject.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;
    private final Logger logger = LoggerFactory.getLogger(CourseController.class);

    @PostMapping("/addCourse")
    public Course addCourse(@RequestBody Course course){
        logger.info("Course Object {}", course.toString());
        return courseService.saveCourse(course);
    }

    @PostMapping("/addCourses")
    public List<Course> addCourses(@RequestBody List<Course> courses){
        return courseService.saveCourses(courses);
    }

    @GetMapping("/courses")
    public List<Course> getAllCourses(){
        return courseService.getCourses();
    }

    @GetMapping("/courseById/{id}")
    public Course findCourseById(@PathVariable int id){
        return courseService.getCourseById(id);
    }

    @GetMapping("/courseByName/{name}")
    public Course findByCourseName(@PathVariable String name){
        return courseService.getCourseByName(name);
    }

    @GetMapping("/listCourseByUsername/{username}")
    public List<Course> findCourseByUsername(@PathVariable String username){
        return courseService.getCoursesForUser(username);
    }

    //PUT
    @PutMapping("/update")
    public Course updateCourse(@RequestBody Course course){
        System.out.println("Updated");
        return courseService.updateCourse(course);
    }

    //Delete
    @DeleteMapping("/delete/{id}")
    public String deleteCourse(@PathVariable int id){
        return courseService.deleteCourse(id);
    }



}
