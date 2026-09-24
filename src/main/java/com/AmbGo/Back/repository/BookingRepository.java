package com.AmbGo.Back.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AmbGo.Back.entity.Booking;
import com.AmbGo.Back.entity.Driver;
import com.AmbGo.Back.entity.Passenger;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByPassenger(Passenger passenger);
    List<Booking> findByDriver(Driver driver);
    Optional<Booking> findByIdAndPassenger(Long id, Passenger passenger);
    Optional<Booking> findByIdAndDriver(Long id, Driver driver);
}