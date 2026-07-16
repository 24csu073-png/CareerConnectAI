package com.careerconnect.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.careerconnect.exception.ResourceNotFoundException;
import com.careerconnect.model.PlacementDrive;
import com.careerconnect.repository.PlacementDriveRepository;
import com.careerconnect.service.PlacementDriveService;

@Service
public class PlacementDriveServiceImpl implements PlacementDriveService {

    @Autowired
    private PlacementDriveRepository placementDriveRepository;

    @Override
    public PlacementDrive savePlacementDrive(PlacementDrive drive) {
        return placementDriveRepository.save(drive);
    }

    @Override
    public PlacementDrive getPlacementDriveById(Long id) {
        return placementDriveRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Placement Drive not found with id " + id));
    }

    @Override
    public List<PlacementDrive> getAllPlacementDrives() {
        return placementDriveRepository.findAll();
    }

    @Override
    public PlacementDrive updatePlacementDrive(Long id, PlacementDrive drive) {

        PlacementDrive existing = placementDriveRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Placement Drive not found with id " + id));

        existing.setTitle(drive.getTitle());
        existing.setCompanyName(drive.getCompanyName());
        existing.setLocation(drive.getLocation());
        existing.setDriveDate(drive.getDriveDate());
        existing.setMinimumCgpa(drive.getMinimumCgpa());
        existing.setJobRole(drive.getJobRole());

        return placementDriveRepository.save(existing);
    }

    @Override
    public void deletePlacementDrive(Long id) {

        placementDriveRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Placement Drive not found with id " + id));

        placementDriveRepository.deleteById(id);
    }
}