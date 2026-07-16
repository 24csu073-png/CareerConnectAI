package com.careerconnect.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.careerconnect.exception.ResourceNotFoundException;
import com.careerconnect.model.Student;
import com.careerconnect.repository.StudentRepository;
import com.careerconnect.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student not found with id " + id));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Long id, Student student) {

        Student existing = studentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student not found with id " + id));

        existing.setName(student.getName());
        existing.setEmail(student.getEmail());
        existing.setCgpa(student.getCgpa());
        existing.setBacklogs(student.getBacklogs());
        existing.setGraduationYear(student.getGraduationYear());
        existing.setSkills(student.getSkills());

        return studentRepository.save(existing);
    }

    @Override
    public void deleteStudent(Long id) {

        studentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student not found with id " + id));

        studentRepository.deleteById(id);
    }
}