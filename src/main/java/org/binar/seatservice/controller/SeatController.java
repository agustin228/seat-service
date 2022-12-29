package org.binar.seatservice.controller;


import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.binar.seatservice.model.Seats;
import org.binar.seatservice.service.SeatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/seat")
public class SeatController {

    @Autowired
    SeatServiceImpl seatService;

    @PostMapping("/post-seats")
    @Operation(summary = "Menambahkan nama film baru")
    public ResponseEntity insertSeat(@RequestParam("number") Integer number,
                                     @RequestParam("studio") String studio,
                                     @RequestParam("studioName") String studioName) {
        try {
            seatService.insertSeat(number, studio, studioName);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("ERROR has been found! because : {}", e.getMessage());
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }



    @GetMapping("/get-seats")
    @Operation(summary = "Menampilkan film yang sedang rilis")
    public ResponseEntity searchShowingFilm(@RequestParam("number") Integer number,
                                            @RequestParam("studio") String studio,
                                            @RequestParam("studioName") String studioName) {
        try {
            List<Seats> seatsList = seatService.getSeat(number, studio, studioName);
            Map<String, List<Seats>> resp = new HashMap<>();
            resp.put("Film yang sedang rilis", seatsList);
            return new ResponseEntity(resp, HttpStatus.OK);
        } catch (Exception e) {
            log.error("ERROR has been found! because {}", e.getMessage());
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }



}
