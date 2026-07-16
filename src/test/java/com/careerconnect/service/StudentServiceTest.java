package com.careerconnect.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.careerconnect.exception.ResourceNotFoundException;
import com.careerconnect.model.Student;
import com.careerconnect.repository.StudentRepository;
import com.careerconnect.service.impl.StudentServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    private Student student;

    @BeforeEach
    void setUp() {

        student = new Student();

        student.setId(1L);
        student.setName("Harsh Pratap Singh");
        student.setEmail("harsh@gmail.com");
        student.setCgpa(8.5);
        student.setBacklogs(0);
        student.setGraduationYear(2028);
        student.setSkills(Arrays.asList("Java", "Spring Boot", "MySQL"));
    }

    @Test
    void testSaveStudent() {

        when(studentRepository.save(student)).thenReturn(student);

        Student savedStudent = studentService.saveStudent(student);

        assertNotNull(savedStudent);
        assertEquals("Harsh Pratap Singh", savedStudent.getName());

        verify(studentRepository, times(1)).save(student);
    }

    @Test
    void testGetStudentById() {

        when(studentRepository.findById(1L))
                .thenReturn(Optional.of(student));

        Student foundStudent = studentService.getStudentById(1L);

        assertEquals(1L, foundStudent.getId());
        assertEquals("Harsh Pratap Singh", foundStudent.getName());

        verify(studentRepository, times(1)).findById(1L);
    }

    @Test
    void testGetStudentByIdNotFound() {

        when(studentRepository.findById(1L))
                .thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class,
                () -> studentService.getStudentById(1L));

        verify(studentRepository, times(1)).findById(1L);
    }

    @Test
    void testGetAllStudents() {

        List<Student> students = Arrays.asList(student);

        when(studentRepository.findAll())
                .thenReturn(students);

        List<Student> studentList = studentService.getAllStudents();

        assertEquals(1, studentList.size());

        verify(studentRepository, times(1)).findAll();
    }

    @Test
    void testUpdateStudent() {

        Student updated = new Student();

        updated.setName("Harsh");
        updated.setEmail("harsh@gmail.com");
        updated.setCgpa(9.2);
        updated.setBacklogs(0);
        updated.setGraduationYear(2028);
        updated.setSkills(Arrays.asList("Java", "React"));

        when(studentRepository.findById(1L))
                .thenReturn(Optional.of(student));

        when(studentRepository.save(any(Student.class)))
                .thenReturn(student);

        Student result = studentService.updateStudent(1L, updated);

        assertEquals("Harsh", result.getName());

        verify(studentRepository).findById(1L);
        verify(studentRepository).save(any(Student.class));
    }

    @Test
    void testDeleteStudent() {

        when(studentRepository.findById(1L))
                .thenReturn(Optional.of(student));

        doNothing().when(studentRepository).deleteById(1L);

        studentService.deleteStudent(1L);

        verify(studentRepository).deleteById(1L);
    }

    @Test
    void testDeleteStudentNotFound() {

        when(studentRepository.findById(1L))
                .thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class,
                () -> studentService.deleteStudent(1L));

        verify(studentRepository, never()).deleteById(anyLong());
    }
}