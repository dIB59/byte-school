package dev.byteschool.byteschoolapp.course;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;

//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id")
@Getter
@Entity
@NoArgsConstructor
@Table(name = "course")
public class Course implements HasStudents {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    @Getter
    private LocalDate startDate;
    private LocalDate endDate;
    private String name;
    @Enumerated(EnumType.STRING)
    private Module type;
    private Slot slot;
    private int maxCapacity;
    @ManyToMany(mappedBy = "courses")
    @JsonIgnoreProperties(value = "courses")
    private Set<Student> students;

    public Course(String name, Module type, int maxCapacity, Slot slot) {
        this.name = name;
        this.slot = slot;
        this.type = type;
        this.maxCapacity = maxCapacity;
        this.students = new HashSet<>();
        this.startDate = getStartDateForNewCourse(LocalDate.now());
        this.endDate = startDate.plusWeeks(2);
    }

    public boolean canAddStudent() {
        return students.size() < maxCapacity;
    }

    public Student addStudent(Student student) {
        if (!canAddStudent()) {
            throw new IllegalArgumentException("Can't add student to course. Max size reached");
        }
        students.add(student);
        return student;
    }

    @Override
    public List<Student> getStudents() {
        return students.stream().toList();
    }

    public LocalDate getStartDateForNewCourse(LocalDate today) {
        var startDate = today.plusDays(1).with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
        int weekOfYear = today.plusDays(1).get(ChronoField.ALIGNED_WEEK_OF_YEAR);
        return (weekOfYear % 2 == 0) ? startDate.plusWeeks(1) : startDate;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "startDate = " + startDate + ", " +
                "endDate = " + endDate + ", " +
                "name = " + name + ", " +
                "type = " + type + ", " +
                "slot = " + slot + ", " +
                "maxCapacity = " + maxCapacity + ")";
    }
}
