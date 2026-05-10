package com.backend.repository;

import com.backend.entity.Vendor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VendorRepository
        extends JpaRepository<Vendor, Long> {

    Optional<Vendor> findByEmail(String email);
}