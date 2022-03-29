package com.example.msscbrewery.web.controller;

import com.example.msscbrewery.web.model.BeerDTO;
import com.example.msscbrewery.web.model.CustomerDTO;
import com.example.msscbrewery.web.service.BeerService;
import com.example.msscbrewery.web.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
    * Created by Maximiliano Lencina on 2022-03-26
 */
@RequestMapping("/api/v1/customer")
@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable UUID id) {
        return new ResponseEntity<>(customerService.getCustomer(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody CustomerDTO customerDTO){
        CustomerDTO createdCustomerDTO = customerService.save(customerDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location" , "/api/v1/beer/" + createdCustomerDTO.getId().toString());

        return ResponseEntity.status(HttpStatus.CREATED)
                .headers(httpHeaders)
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity create(@PathVariable UUID id, @RequestBody CustomerDTO customerDTO){
        customerService.update(id, customerDTO);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id){
        customerService.delete(id);
    }
}
