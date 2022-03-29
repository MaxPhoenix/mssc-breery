package com.example.msscbrewery.web.controller;

import com.example.msscbrewery.web.model.BeerDTO;
import com.example.msscbrewery.web.service.BeerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by Maximiliano Lencina on 2022-03-24
 */
@RequestMapping("/api/v1/beer")
@RestController
@RequiredArgsConstructor
public class BeerController {

    private final BeerService beerService;

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDTO> getBeer(@PathVariable UUID beerId) {
        return new ResponseEntity<>(beerService.getBeer(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody BeerDTO beerDTO){
        BeerDTO savedBeerDTO = beerService.save(beerDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/api/v1/beer/" + savedBeerDTO.getId().toString());

        return ResponseEntity.status(HttpStatus.CREATED)
                .headers(httpHeaders)
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable UUID id, @RequestBody BeerDTO beerDTO){
        BeerDTO editedBeerDTO = beerService.update(id, beerDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id){
        beerService.deleteById(id);
    }

}
