package dev.byteschool.byteschoolapp.course;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/courses")
public class CourseController {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public CourseController(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    @PostMapping("{courseId}/students")
    @ResponseStatus(HttpStatus.CREATED)
    public Student addStudent(
            @PathVariable int courseId,
            @RequestParam int studentId
    ) {
        var course =  courseRepository.findById(courseId).orElseThrow();
        var student = studentRepository.findById(studentId).orElseThrow().addCourse(course);
        var added = course.addStudent(student);
        courseRepository.save(course);
        return added;
    }

    @PostMapping
    public Course createCourse(
            @RequestParam String name,
            @RequestParam Module module,
            @RequestParam Slot slot
    ) {
       return courseRepository.save(new Course(name, module, 4, slot));
    }

    @GetMapping
    public List<Course> getAllStudents() {
        return courseRepository.findAll();
    }
}
