package dev.byteschool.byteschoolapp.course;

import java.time.DayOfWeek;
import java.time.LocalDate;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CourseStartDateTest {
    /**
     * Method under test: {@link Course#getStartDateForNewCourse(LocalDate)}
     */
    @ParameterizedTest
    @MethodSource("provideDatesForNewCourse")
    void testGetStartDateForNewCourse(LocalDate courseBuyDate, LocalDate expectedStartDate) {
        // Arrange
        Course course = new Course();
        // Act
        LocalDate actualStartDateForNewCourse = course.getStartDateForNewCourse(courseBuyDate);
        // Assert
        Assertions.assertEquals(DayOfWeek.MONDAY, actualStartDateForNewCourse.getDayOfWeek());
        Assertions.assertEquals(expectedStartDate, actualStartDateForNewCourse);
    }

    static Stream<Arguments> provideDatesForNewCourse() {
        return Stream.of(
                Arguments.of(LocalDate.of(2024, 6, 7), LocalDate.of(2024, 6, 10)),
                Arguments.of(LocalDate.of(2024, 6, 25), LocalDate.of(2024, 7, 8)),
                Arguments.of(LocalDate.of(2024, 6, 30), LocalDate.of(2024, 7, 1)),
                Arguments.of(LocalDate.of(2024, 12, 28), LocalDate.of(2025, 1, 6)),
                Arguments.of(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 8)),
                Arguments.of(LocalDate.of(2024, 2, 29), LocalDate.of(2024, 3, 4)),
                Arguments.of(LocalDate.of(2024, 4, 15), LocalDate.of(2024, 4, 29)),
                Arguments.of(LocalDate.of(2024, 11, 10), LocalDate.of(2024, 11, 18)),
                Arguments.of(LocalDate.of(2024, 8, 3), LocalDate.of(2024, 8, 5)),
                Arguments.of(LocalDate.of(2024, 9, 18), LocalDate.of(2024, 9, 30))
        );
    }
}
