package com.AmbGo.Back.service;

import java.util.List;

import com.AmbGo.Back.dto.DriverLocationDTO;

public interface LocationService {

    Boolean saveDriverLocation(String driverId, Double latitude, Double longitude);

    List<DriverLocationDTO> getNearbyDrivers(Double latitude, Double longitude, Double radius);
    
}