ALTER TABLE course_current_students
DROP
CONSTRAINT fk_coucurstu_on_course;

ALTER TABLE course_current_students
DROP
CONSTRAINT fk_coucurstu_on_student;

CREATE TABLE course_students
(
    course_id   INTEGER NOT NULL,
    students_id INTEGER NOT NULL,
    CONSTRAINT pk_course_students PRIMARY KEY (course_id, students_id)
);

ALTER TABLE course_students
    ADD CONSTRAINT fk_coustu_on_course FOREIGN KEY (course_id) REFERENCES course (id);

ALTER TABLE course_students
    ADD CONSTRAINT fk_coustu_on_student FOREIGN KEY (students_id) REFERENCES student (id);

DROP TABLE course_current_students CASCADE;