package com.careerconnect.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company updateCompany(Long id, Company company) {

        Company existing = companyRepository.findById(id).orElse(null);

        if (existing != null) {

            existing.setCompanyName(company.getCompanyName());
            existing.setIndustry(company.getIndustry());
            existing.setLocation(company.getLocation());
            existing.setHrEmail(company.getHrEmail());
            existing.setWebsite(company.getWebsite());

            return companyRepository.save(existing);
        }

        return null;
    }

    @Override
    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }
}