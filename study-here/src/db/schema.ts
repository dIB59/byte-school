import { serial, text, pgTable, integer, uniqueIndex } from 'drizzle-orm/pg-core';

export const students = pgTable('students', {
  id: serial('id').primaryKey(),
  name: text('name'),
  email: text('email').unique(), 
});

export const courses = pgTable('courses', {
    id: serial('id').primaryKey(),
    courseName: text('course_name'),
    courseCode: text('course_code').unique(), 
  });

export const enrollments = pgTable('enrollments', {
studentId: integer('student_id').references(() => students.id),
courseId: integer('course_id').references(() => courses.id),
}, (enrollments) => ({
uniqueEnrollment: uniqueIndex('unique_enrollment').on(enrollments.studentId, enrollments.courseId) 

}));