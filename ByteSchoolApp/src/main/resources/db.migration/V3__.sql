ALTER TABLE course_students
    DROP CONSTRAINT fk_coustu_on_course;

ALTER TABLE course_students
    DROP CONSTRAINT fk_coustu_on_student;

DROP TABLE course_students CASCADE;