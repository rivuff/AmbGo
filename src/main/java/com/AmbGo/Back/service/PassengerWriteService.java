package com.AmbGo.Back.service;

import com.AmbGo.Back.dto.PassengerRequest;
import com.AmbGo.Back.dto.PassengerResponse;

/**
 * PassengerWriteService
 */
public interface PassengerWriteService {
    PassengerResponse create(PassengerRequest request);
    PassengerResponse update(Long id, PassengerRequest request);
    void deleteById(Long id);
    
}