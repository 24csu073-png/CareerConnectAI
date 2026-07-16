package com.careerconnect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.careerconnect.model.PlacementDrive;
import com.careerconnect.service.PlacementDriveService;

@RestController
@RequestMapping("/placementdrives")
public class PlacementDriveController {

    @Autowired
    private PlacementDriveService placementDriveService;

    @PostMapping
    public PlacementDrive savePlacementDrive(@RequestBody PlacementDrive drive) {
        return placementDriveService.savePlacementDrive(drive);
    }

    @GetMapping("/{id}")
    public PlacementDrive getPlacementDrive(@PathVariable Long id) {
        return placementDriveService.getPlacementDriveById(id);
    }

    @GetMapping
    public List<PlacementDrive> getAllPlacementDrives() {
        return placementDriveService.getAllPlacementDrives();
    }

    @PutMapping("/{id}")
    public PlacementDrive updatePlacementDrive(@PathVariable Long id,
                                               @RequestBody PlacementDrive drive) {
        return placementDriveService.updatePlacementDrive(id, drive);
    }

    @DeleteMapping("/{id}")
    public void deletePlacementDrive(@PathVariable Long id) {
        placementDriveService.deletePlacementDrive(id);
    }
}