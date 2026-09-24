package com.AmbGo.Back.service;

import java.util.List;
import java.util.Optional;

import com.AmbGo.Back.dto.DriverResponse;

/**
 * DriverReadService
 */
public interface DriverReadService {

    Optional<DriverResponse> findById(Long id);
    List<DriverResponse> findAll();
    Optional<DriverResponse> findByEmail(String email);
    List<DriverResponse> findAvailableDrivers();
}