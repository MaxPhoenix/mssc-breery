package com.example.msscbrewery.web.service;

import com.example.msscbrewery.web.model.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Override
    public CustomerDTO getCustomer(UUID id) {
        return CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name("Max Lencina")
                .build();
    }

    @Override
    public CustomerDTO save(CustomerDTO customerDTO) {
        return CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name(customerDTO.getName())
                .build();
    }

    @Override
    public void update(UUID id, CustomerDTO customerDTO) {
        customerDTO.setId(id);
    }

    @Override
    public void delete(UUID id) {
        return;
    }
}
