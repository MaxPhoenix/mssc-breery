package com.example.msscbrewery.web.service;

import com.example.msscbrewery.web.model.CustomerDTO;

import java.util.UUID;

public interface CustomerService {

    CustomerDTO getCustomer(final UUID id);

    CustomerDTO save(CustomerDTO customerDTO);

    void update(UUID id, CustomerDTO customerDTO);

    void delete(UUID id);
}
