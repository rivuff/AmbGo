package com.AmbGo.Back.service;

import java.util.List;
import java.util.Optional;

import com.AmbGo.Back.dto.BookingResponse;

/**
 * Interface for Booking read operations
 * Following Interface Segregation Principle
 */
public interface BookingReadService {
    Optional<BookingResponse> findById(Long id);
    List<BookingResponse> findAll();
    List<BookingResponse> findByPassengerId(Long passengerId);
    List<BookingResponse> findByDriverId(Long driverId);
}