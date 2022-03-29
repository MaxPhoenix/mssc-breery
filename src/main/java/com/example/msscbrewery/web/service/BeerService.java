package com.example.msscbrewery.web.service;

import com.example.msscbrewery.web.model.BeerDTO;

import java.util.UUID;

public interface BeerService {

    BeerDTO getBeer(UUID beerId);

    BeerDTO save(BeerDTO beerDTO);

    BeerDTO update(UUID id, BeerDTO beerDTO);

    void deleteById(UUID id);
}
