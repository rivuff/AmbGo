package com.AmbGo.Back.service.impl;

import java.sql.Driver;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.AmbGo.Back.dto.BookingRequest;
import com.AmbGo.Back.dto.BookingResponse;
import com.AmbGo.Back.dto.DriverLocationDTO;
import com.AmbGo.Back.entity.Booking;
import com.AmbGo.Back.entity.Passenger;
import com.AmbGo.Back.entity.Booking.BookingStatus;
import com.AmbGo.Back.repository.PassengerRepository;
import com.AmbGo.Back.service.BookingService;
import com.AmbGo.Back.service.DriverService;
import com.AmbGo.Back.service.LocationService;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor 
@Service 
@Builder 
public class BookingServiceImpl implements BookingService{

    private final DriverService driverService;
    private final PassengerRepository passengerRepository;
    private final LocationService locationService;

    @Override
    public Optional<BookingResponse> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<BookingResponse> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public List<BookingResponse> findByPassengerId(Long passengerId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByPassengerId'");
    }

    @Override
    public List<BookingResponse> findByDriverId(Long driverId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByDriverId'");
    }

    @Override
    public BookingResponse create(BookingRequest request) {

        Passenger passenger = passengerRepository.findById(request.getPassengerId())
                                .orElseThrow(()-> new IllegalArgumentException("Passenger with this Id not found"));

        Booking booking = Booking.builder()
                                .passenger(passenger)
                                .status(BookingStatus.PENDING)
                                .pickupLocationLongitude(request.getPickupLocationLongitude())
                                .pickupLocationLatitude(request.getPickupLocationLatitude())
                                .build();

        
        List<DriverLocationDTO> drivers = locationService.getNearbyDrivers(request.getPickupLocationLatitude(), request.getPickupLocationLongitude(), 1.0);


        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public BookingResponse update(Long id, BookingRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public BookingResponse updateStatus(Long id, BookingStatus status) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateStatus'");
    }

    @Override
    public Boolean acceptRide(Long id, Integer driverId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'acceptRide'");
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }
    
}
