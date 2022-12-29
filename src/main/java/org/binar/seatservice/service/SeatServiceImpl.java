package org.binar.seatservice.service;

import lombok.extern.slf4j.Slf4j;
import org.binar.seatservice.model.Seats;
import org.binar.seatservice.repository.SeatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class SeatServiceImpl implements SeatService {

    @Autowired
    SeatsRepository seatsRepository;

    @Override
    public void insertSeat(Integer number, String studio, String studioName) {

        try {
            seatsRepository.addChairNumber(number, studio, studioName);
        } catch (Exception e) {
            log.error("ERROR has been found! because : {}", e.getMessage());
        }
    }

    @Override
    public List<Seats> getSeat(Integer number, String studio, String studioName) {
        List<Seats> seatsList = new ArrayList<>();
        try {
            seatsList = seatsRepository.getChairNumber(number, studio, studioName);
            return seatsList;
        } catch (Exception e) {
            log.error("ERROR has been found! because : {}", e.getMessage());
            return null;
        }
    }
}
