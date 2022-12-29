package org.binar.seatservice.service;

import org.binar.seatservice.model.Seats;

import java.util.List;

public interface SeatService {
    void insertSeat(Integer number, String studio, String studioName);
    List<Seats> getSeat(Integer number, String studio, String studioName);
}
