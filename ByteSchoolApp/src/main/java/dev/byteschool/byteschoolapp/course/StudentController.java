package dev.byteschool.byteschoolapp.course;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/students")
public class StudentController {

    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Student createStudent(@RequestParam String name, @RequestParam String email) {
        return repository.save(new Student(name, email));
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return repository.findAll();
    }
}
