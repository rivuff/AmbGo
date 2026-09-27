package com.AmbGo.Back.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AmbGo.Back.dto.DriverLocationDTO;
import com.AmbGo.Back.dto.NearbyDriversRequestDTO;
import com.AmbGo.Back.service.LocationService;

import lombok.RequiredArgsConstructor;

@RestController 
@RequiredArgsConstructor 
@RequestMapping("/api/v1/location")
public class LocationController {
    private final LocationService locationService;

    @PostMapping("/driverlocation")
    public ResponseEntity<Boolean> saveDriverLocation(@RequestBody  DriverLocationDTO driverLocationDTO){
        Boolean saved = locationService.saveDriverLocation(driverLocationDTO.getDriverId(), driverLocationDTO.getLatitude(), driverLocationDTO.getLongitude());

        return ResponseEntity.ok(saved);
    }

    @GetMapping("/nearbydrivers")
    public ResponseEntity<List<DriverLocationDTO>> getNearByDrivers(@RequestBody NearbyDriversRequestDTO nearbyDriversRequestDTO){
        List<DriverLocationDTO> nearByDrivers = locationService.getNearbyDrivers
        (nearbyDriversRequestDTO.getLatitude(),nearbyDriversRequestDTO.getLongitude(), nearbyDriversRequestDTO.getRadius());

        return ResponseEntity.ok(nearByDrivers);
    }
}
