CREATE TABLE students(
student_id serial primary key NOT NULL,
name character varying ,
email character varying  ,
password character varying 

);
 
CREATE TABLE marks(
m_id serial primary key NOT NULL,
student_id integer,
english float   ,
maths float ,
marathi float 

);
 
ALTER TABLE marks 
ADD CONSTRAINT fk_students_marks FOREIGN KEY (student_id) REFERENCES students;
