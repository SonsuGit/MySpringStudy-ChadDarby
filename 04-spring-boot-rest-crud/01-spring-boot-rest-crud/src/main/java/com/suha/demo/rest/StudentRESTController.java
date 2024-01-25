package com.suha.demo.rest;

import com.suha.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRESTController {
    private List<Student> theStudents;

    // define @PostConstruct to load the student data ... only once!
    @PostConstruct
    public void loadData(){

        theStudents = new ArrayList<>();

        theStudents.add(new Student("Puma","king"));
        theStudents.add(new Student("Lee","Sin"));
        theStudents.add(new Student("Pal","Queen"));
    }
    // define endpoint for /students - return a list of students

    @GetMapping("/students")
    public List<Student> getStudents(){

        return theStudents;
    }
    // define endpoint for /students/{studentID} - return sutdent at index
    @GetMapping("/students/{studentID}")
    public Student getStudent(@PathVariable int studentID){
        // chech the studentID again list size
        if ((studentID >= theStudents.size()) || studentID < 0){
            throw new StudentNotFoundException("Student id not found - " + studentID);
        }
        return theStudents.get(studentID);
    }


}
