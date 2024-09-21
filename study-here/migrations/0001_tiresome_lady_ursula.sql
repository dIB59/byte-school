CREATE TABLE IF NOT EXISTS "courses" (
	"id" serial PRIMARY KEY NOT NULL,
	"course_name" text,
	"course_code" text,
	CONSTRAINT "courses_course_code_unique" UNIQUE("course_code")
);
--> statement-breakpoint
CREATE TABLE IF NOT EXISTS "enrollments" (
	"student_id" integer,
	"course_id" integer
);
--> statement-breakpoint
CREATE TABLE IF NOT EXISTS "students" (
	"id" serial PRIMARY KEY NOT NULL,
	"name" text,
	"email" text,
	CONSTRAINT "students_email_unique" UNIQUE("email")
);
--> statement-breakpoint
DROP TABLE "todo";--> statement-breakpoint
DO $$ BEGIN
 ALTER TABLE "enrollments" ADD CONSTRAINT "enrollments_student_id_students_id_fk" FOREIGN KEY ("student_id") REFERENCES "public"."students"("id") ON DELETE no action ON UPDATE no action;
EXCEPTION
 WHEN duplicate_object THEN null;
END $$;
--> statement-breakpoint
DO $$ BEGIN
 ALTER TABLE "enrollments" ADD CONSTRAINT "enrollments_course_id_courses_id_fk" FOREIGN KEY ("course_id") REFERENCES "public"."courses"("id") ON DELETE no action ON UPDATE no action;
EXCEPTION
 WHEN duplicate_object THEN null;
END $$;
--> statement-breakpoint
CREATE UNIQUE INDEX IF NOT EXISTS "unique_enrollment" ON "enrollments" USING btree ("student_id","course_id");