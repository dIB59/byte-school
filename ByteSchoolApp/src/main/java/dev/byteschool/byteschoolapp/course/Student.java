package dev.byteschool.byteschoolapp.course;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;


//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id")
@Entity
@Getter
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    private String name;
    private String email;

    @ManyToMany
    @JoinTable(
            name = "student_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "courses_id")
    )
    @JsonIgnoreProperties(value = "students")
    private final Set<Course> courses = new HashSet<>();

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Student() {}

    public Student addCourse(Course course){
        this.courses.add(course);
        return this;
    }
}
