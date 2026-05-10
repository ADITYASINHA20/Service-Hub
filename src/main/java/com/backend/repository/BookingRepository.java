package com.backend.repository;

import com.backend.entity.Booking;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository
        extends JpaRepository<Booking, Long> {

    List<Booking> findByCustomerName(
            String customerName
    );

}