package org.propertyservice.controllers;

import lombok.RequiredArgsConstructor;
import org.propertyservice.dto.CityDto;
import org.propertyservice.services.CityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cities")
public class CityController {
    private final CityService cityService;
    @PostMapping
    public ResponseEntity<Object> add(@RequestBody CityDto cityDto) {
        try {
            CityDto savedCityDto = cityService.add(cityDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedCityDto);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody CityDto cityDto) {
        try {
            CityDto updatedCityDto = cityService.update(id, cityDto);
            return ResponseEntity.ok().body(updatedCityDto);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        try {
            CityDto cityDto = cityService.findById(id);
            return ResponseEntity.status(HttpStatus.FOUND).body(cityDto);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.valueOf(e instanceof NotFoundException ? "NOT_FOUND" : "BAD_REQUEST")).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<Page<CityDto>> findAll(@RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "10") int size,
                                                 @RequestParam(defaultValue = "name") String[] sort) {
        Page<CityDto> cities = cityService.findAll(page, size, Sort.by(sort));
        return ResponseEntity.ok().body(cities);
    }
}
