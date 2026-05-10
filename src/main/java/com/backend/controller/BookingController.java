package com.backend.controller;

import com.backend.entity.Booking;
import com.backend.repository.BookingRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/bookings")

@CrossOrigin("*")

public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    // CREATE BOOKING
    @PostMapping
    public Booking createBooking(

            @RequestBody Booking booking

    ) {

        booking.setStatus("PENDING");

        return bookingRepository.save(booking);

    }

    // GET ALL BOOKINGS
    @GetMapping
    public List<Booking> getBookings() {

        return bookingRepository.findAll();

    }

    // CUSTOMER BOOKINGS
    @GetMapping("/customer/{customerName}")

    public List<Booking> customerBookings(

            @PathVariable
            String customerName

    ) {

        return bookingRepository
                .findByCustomerName(
                        customerName
                );

    }

    // ACCEPT BOOKING
    @PutMapping("/accept/{id}")

    public Booking acceptBooking(

            @PathVariable Long id

    ) {

        Booking booking =
                bookingRepository
                        .findById(id)
                        .orElseThrow();

        booking.setStatus(
                "ACCEPTED"
        );

        return bookingRepository
                .save(booking);

    }

    // DELIVER BOOKING
    @PutMapping("/deliver/{id}")

    public Booking deliverBooking(

            @PathVariable Long id

    ) {

        Booking booking =
                bookingRepository
                        .findById(id)
                        .orElseThrow();

        booking.setStatus(
                "DELIVERED"
        );

        return bookingRepository
                .save(booking);

    }
}