package com.backend.entity;

import jakarta.persistence.*;

@Entity

public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String customerName;

    private String serviceName;

    private String address;

    private String status;

    // KEEP VENDOR
    @ManyToOne
    private Vendor vendor;

    public Booking() {
    }

    // ID
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // CUSTOMER NAME
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(
        String customerName
    ) {
        this.customerName =
            customerName;
    }

    // SERVICE NAME
    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(
        String serviceName
    ) {
        this.serviceName =
            serviceName;
    }

    // ADDRESS
    public String getAddress() {
        return address;
    }

    public void setAddress(
        String address
    ) {
        this.address = address;
    }

    // STATUS
    public String getStatus() {
        return status;
    }

    public void setStatus(
        String status
    ) {
        this.status = status;
    }

    // VENDOR
    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(
        Vendor vendor
    ) {
        this.vendor = vendor;
    }
}