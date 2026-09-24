package com.AmbGo.Back.service;

import java.util.List;
import java.util.Optional;

import com.AmbGo.Back.dto.PassengerResponse;

/**
 * PassengerReadService
 */
public interface PassengerReadService {
    Optional<PassengerResponse> findById(Long id);
    List<PassengerResponse> findAll();
    Optional<PassengerResponse> findByEmail(String email);
    
}