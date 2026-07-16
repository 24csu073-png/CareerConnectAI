package com.careerconnect.service;

import java.util.List;

import com.careerconnect.model.Company;

public interface CompanyService {

    Company saveCompany(Company company);

    Company getCompanyById(Long id);

    List<Company> getAllCompanies();

    Company updateCompany(Long id, Company company);

    void deleteCompany(Long id);

}