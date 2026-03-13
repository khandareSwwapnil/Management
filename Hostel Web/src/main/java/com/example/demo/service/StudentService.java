package com.example.demo.service;

import java.util.List;


import com.example.demo.entity.Student;


public interface StudentService {

	Student createStudent(Student student, Long bedId);

    Student getStudentById(Long id);

    List<Student> getAllStudents();

    List<Student> getStudentsByStatus(String status);

    Student updateStudent(Long id, Student student);

    Student changeBed(Long studentId, Long newBedId);

    void deleteStudent(Long id);

	Student saveStudent(Student student, Long bedId);


}
