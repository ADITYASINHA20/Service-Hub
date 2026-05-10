package com.backend.controller;

import com.backend.entity.ServiceEntity;
import com.backend.repository.ServiceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
@CrossOrigin(origins = "http://localhost:5173")
public class ServiceController {

    @Autowired
    private ServiceRepository serviceRepository;

    // GET ALL SERVICES
    @GetMapping
    public List<ServiceEntity> getServices() {

        return serviceRepository.findAll();
    }

    // ADD SERVICE
    @PostMapping
    public ServiceEntity addService(
            @RequestBody ServiceEntity service
    ) {

        return serviceRepository.save(service);
    }
}