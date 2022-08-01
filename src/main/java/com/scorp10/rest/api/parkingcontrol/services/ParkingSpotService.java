package com.scorp10.rest.api.parkingcontrol.services;

import com.scorp10.rest.api.parkingcontrol.repositories.ParkingSpotRepository;
import org.springframework.stereotype.Service;

@Service
public class ParkingSpotService {

    final ParkingSpotRepository parkingSpotRepository;

    public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }

}
