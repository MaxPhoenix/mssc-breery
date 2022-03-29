package com.example.msscbrewery.web.service;

import com.example.msscbrewery.web.model.BeerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by Maximiliano Lencina on 24-03-2022
 */
@Slf4j
@Service
public class BeerServiceImpl implements BeerService{

    @Override
    public BeerDTO getBeer(UUID beerId) {
        return BeerDTO.builder()
                .id(UUID.fromString("123e4567-e89b-12d3-a456-426614174000"))
                .beerName("Corona")
                .beerStyle("Blonde")
                .build();
    }

    @Override
    public BeerDTO save(BeerDTO beerDTO) {
        return BeerDTO.builder()
                .id(UUID.randomUUID())
                .beerName(beerDTO.getBeerName())
                .build();
    }

    @Override
    public BeerDTO update(UUID id, BeerDTO beerDTO) {
        beerDTO.setId(id);
        return beerDTO;
    }

    @Override
    public void deleteById(UUID id) {
        log.debug("Deleting beer with id {}", id);
    }
}
