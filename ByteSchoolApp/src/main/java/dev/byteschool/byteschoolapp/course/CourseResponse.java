package dev.byteschool.byteschoolapp.course;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;


@Data
public class CourseResponse implements Serializable {

    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String name;
    private Module type;
    private Slot slot;
    private int maxCapacity;
    @JsonIgnoreProperties(value = "courses")
    private Set<Student> currentStudents;
}
