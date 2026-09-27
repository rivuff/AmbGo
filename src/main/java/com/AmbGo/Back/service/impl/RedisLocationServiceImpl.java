package com.AmbGo.Back.service.impl;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.connection.RedisGeoCommands.GeoLocation;
import org.springframework.data.redis.core.GeoOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.AmbGo.Back.dto.DriverLocationDTO;
import com.AmbGo.Back.service.LocationService;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class RedisLocationServiceImpl implements LocationService{

    private static final String DRIVER_GEO_OPS_KEY = "driver:geo";

    private final StringRedisTemplate stringRedisTemplate;

    @Override
    public Boolean saveDriverLocation(String driverId, Double latitude, Double longitude) {
        if (driverId == null || driverId.trim().isEmpty()) {
            throw new IllegalArgumentException("Driver ID can't be empty");
        }

        GeoOperations<String, String> geoOperations = stringRedisTemplate.opsForGeo();

        Long added = geoOperations.add(DRIVER_GEO_OPS_KEY, 
            new RedisGeoCommands.GeoLocation<>(driverId, new Point(longitude, latitude))
        ); 
        
        return added != null;
    }

    @Override
    public List<DriverLocationDTO> getNearbyDrivers(Double latitude, Double longitude, Double radius) {

        GeoOperations<String, String> geoOperations = stringRedisTemplate.opsForGeo();

        Distance radiusDistance = new Distance(radius, Metrics.KILOMETERS);

        Circle circle = new Circle(new Point(longitude, latitude), radiusDistance);

        GeoResults<GeoLocation<String>> results = geoOperations.radius(DRIVER_GEO_OPS_KEY, circle);

        List<DriverLocationDTO> driverLocations = new ArrayList<>();

        for(GeoResult<GeoLocation<String>> result : results){
            Point point = geoOperations.position(DRIVER_GEO_OPS_KEY, result.getContent().getName()).get(0);

            DriverLocationDTO driverLocation = DriverLocationDTO.builder()
                                                .driverId(result.getContent().getName())
                                                .latitude(point.getY())
                                                .longitude(point.getX())
                                                .build();

            driverLocations.add(driverLocation);
        }

        return driverLocations;

    }
    
}
