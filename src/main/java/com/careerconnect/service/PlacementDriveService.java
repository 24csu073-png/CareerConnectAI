package com.careerconnect.service;

import java.util.List;

import com.careerconnect.model.PlacementDrive;

public interface PlacementDriveService {

    PlacementDrive savePlacementDrive(PlacementDrive drive);

    PlacementDrive getPlacementDriveById(Long id);

    List<PlacementDrive> getAllPlacementDrives();

    PlacementDrive updatePlacementDrive(Long id, PlacementDrive drive);

    void deletePlacementDrive(Long id);

}