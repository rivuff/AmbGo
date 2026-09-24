package com.AmbGo.Back.service;

import com.AmbGo.Back.dto.DriverRequest;
import com.AmbGo.Back.dto.DriverResponse;

/**
 * DriverWriteService
 */
public interface DriverWriteService {

    DriverResponse create(DriverRequest request);
    DriverResponse update(Long id, DriverRequest request);
    void deleteById(Long id);
}