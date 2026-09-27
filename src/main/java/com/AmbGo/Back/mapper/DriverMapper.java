package com.AmbGo.Back.mapper;


import org.springframework.stereotype.Component;

import com.AmbGo.Back.dto.DriverRequest;
import com.AmbGo.Back.dto.DriverResponse;
import com.AmbGo.Back.entity.Driver;

@Component 
public class DriverMapper {
    
    public Driver toEntity(DriverRequest request) {
        return Driver.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .licenseNumber(request.getLicenseNumber())
                .vehicleModel(request.getVehicleModel())
                .vehiclePlateNumber(request.getVehiclePlateNumber())
                .isAvailable(request.getIsAvailable())
                .build();
    }
    
    public DriverResponse toResponse(Driver driver) {
        return DriverResponse.builder()
                .id(driver.getId())
                .name(driver.getName())
                .email(driver.getEmail())
                .phoneNumber(driver.getPhoneNumber())
                .licenseNumber(driver.getLicenseNumber())
                .vehicleModel(driver.getVehicleModel())
                .vehiclePlateNumber(driver.getVehiclePlateNumber())
                .isAvailable(driver.getIsAvailable())
                .createdAt(driver.getCreatedAt())
                .updatedAt(driver.getUpdatedAt())
                .build();
    }
    
    public void updateEntity(Driver driver, DriverRequest request) {
        driver.setName(request.getName());
        driver.setEmail(request.getEmail());
        driver.setPhoneNumber(request.getPhoneNumber());
        driver.setLicenseNumber(request.getLicenseNumber());
        driver.setVehicleModel(request.getVehicleModel());
        driver.setVehiclePlateNumber(request.getVehiclePlateNumber());
        driver.setIsAvailable(request.getIsAvailable());
    }
}