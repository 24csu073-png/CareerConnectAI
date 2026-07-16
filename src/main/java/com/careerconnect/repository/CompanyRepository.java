package com.careerconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.careerconnect.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}