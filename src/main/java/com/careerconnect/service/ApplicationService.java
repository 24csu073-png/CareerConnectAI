package com.careerconnect.service;

import java.util.List;

import com.careerconnect.model.Application;

public interface ApplicationService {

    Application saveApplication(Application application);

    Application getApplicationById(Long id);

    List<Application> getAllApplications();

    Application updateApplication(Long id, Application application);

    void deleteApplication(Long id);
}