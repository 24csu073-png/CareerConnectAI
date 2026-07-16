package com.careerconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.careerconnect.model.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

}