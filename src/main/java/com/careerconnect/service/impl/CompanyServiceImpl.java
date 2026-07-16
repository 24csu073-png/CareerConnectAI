package com.careerconnect.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.careerconnect.exception.ResourceNotFoundException;
import com.careerconnect.model.Company;
import com.careerconnect.repository.CompanyRepository;
import com.careerconnect.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Company not found with id " + id));
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company updateCompany(Long id, Company company) {

        Company existing = companyRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Company not found with id " + id));

        existing.setCompanyName(company.getCompanyName());
        existing.setIndustry(company.getIndustry());
        existing.setLocation(company.getLocation());
        existing.setWebsite(company.getWebsite());
        existing.setHrEmail(company.getHrEmail());

        return companyRepository.save(existing);
    }

    @Override
    public void deleteCompany(Long id) {

        companyRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Company not found with id " + id));

        companyRepository.deleteById(id);
    }
}