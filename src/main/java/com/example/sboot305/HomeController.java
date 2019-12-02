package com.example.sboot305;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;


    @RequestMapping("/")
    public String index(Model model){
        Student student = new Student();
        student.setFirstname("Eathyn");
        student.setLastname("Edwards");

        Course course = new Course();
        course.setTitle("Math");
        course.setType("Core class");
        course.setDescription("Simple Rithmetic...");
        Set<Course> courses = new HashSet<Course>();
        courses.add(course);

        student.setCourses(courses);
        studentRepository.save(student);

        model.addAttribute("students", studentRepository.findAll());

        return "index";
    }
}

