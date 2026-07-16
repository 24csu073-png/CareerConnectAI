package com.careerconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.careerconnect.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}