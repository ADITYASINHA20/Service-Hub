package com.backend.repository;

import com.backend.entity.ServiceEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository
        extends JpaRepository<ServiceEntity, Long> {
}