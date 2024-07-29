package dev.byteschool.byteschoolapp.course;

import java.util.List;

public interface HasStudents {

    Student addStudent(Student student);
    List<Student> getStudents();
//    Optional<Student>  removeStudent(Student student);


}
