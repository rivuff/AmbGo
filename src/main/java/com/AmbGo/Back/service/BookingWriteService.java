package com.AmbGo.Back.service;

import com.AmbGo.Back.dto.BookingRequest;
import com.AmbGo.Back.dto.BookingResponse;
import com.AmbGo.Back.entity.Booking;

/**
 * BookingWriteService
 */
public interface BookingWriteService {

    BookingResponse create(BookingRequest request);
    BookingResponse update(Long id, BookingRequest request);
    BookingResponse updateStatus(Long id, Booking.BookingStatus status);
    Boolean acceptRide(Long id, Integer driverId);
    void deleteById(Long id);
}