CREATE DATABASE IF NOT EXISTS student_db;

USE student_db;


CREATE TABLE IF NOT EXISTS students (
    registration_number INT NOT NULL UNIQUE,
    name VARCHAR(255) NOT NULL,
    roll_number INT AUTO_INCREMENT,
    email VARCHAR(255) UNIQUE NOT NULL,
    course VARCHAR(255) NOT NULL,
    PRIMARY KEY (roll_number, registration_number, course)
);


ALTER TABLE students MODIFY COLUMN registration_number VARCHAR(50);

