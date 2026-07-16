package com.careerconnect.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.careerconnect.model.Application;
import com.careerconnect.repository.ApplicationRepository;
import com.careerconnect.service.ApplicationService;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public Application saveApplication(Application application) {
        return applicationRepository.save(application);
    }

    @Override
    public Application getApplicationById(Long id) {
        return applicationRepository.findById(id).orElse(null);
    }
    @Override
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    @Override
    public Application updateApplication(Long id, Application application) {

    	Application existing = applicationRepository.findById(id).orElse(null);
        if (existing != null) {

            existing.setStudentId(application.getStudentId());
            existing.setCompanyId(application.getCompanyId());
            existing.setJobRole(application.getJobRole());
            existing.setStatus(application.getStatus());

            return applicationRepository.save(existing);
        }

        return null;
    }

    @Override
    public void deleteApplication(Long id) {
        applicationRepository.deleteById(id);
    }
}