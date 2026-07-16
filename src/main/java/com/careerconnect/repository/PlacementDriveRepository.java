package com.careerconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.careerconnect.model.PlacementDrive;

@Repository
public interface PlacementDriveRepository extends JpaRepository<PlacementDrive, Long> {

}