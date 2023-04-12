package org.propertyservice.controllers;

import lombok.RequiredArgsConstructor;
import org.propertyservice.dto.PropertyLocationDto;
import org.propertyservice.services.PropertyLocationService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/locations")
@CrossOrigin(origins = "http://localhost:4200")
public class PropertyLocationController {
    private final PropertyLocationService propertyLocationService;
    @GetMapping("")
    public ResponseEntity<Page<PropertyLocationDto>> getAll(@RequestParam(defaultValue = "0") int page,
                                                            @RequestParam(defaultValue = "10") int size) {
        Page<PropertyLocationDto> propertyLocations = propertyLocationService.findAll(page, size);
        return ResponseEntity.ok(propertyLocations);
    }
    @GetMapping("/all")
    public ResponseEntity<List<PropertyLocationDto>> getAll() {
        List<PropertyLocationDto> propertyLocations = propertyLocationService.findAll();
        return ResponseEntity.ok(propertyLocations);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id) {
        try {
            PropertyLocationDto propertyLocation = propertyLocationService.findById(id);
            return ResponseEntity.status(HttpStatus.FOUND).body(propertyLocation);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.valueOf(e instanceof NotFoundException ? "NOT_FOUND" : "BAD_REQUEST")).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> add(@RequestBody PropertyLocationDto propertyLocationDto) {

        try {
            PropertyLocationDto savedPropertyLocation = propertyLocationService.add(propertyLocationDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedPropertyLocation);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody PropertyLocationDto propertyLocationDto) {
        try {
            PropertyLocationDto updatedPropertyLocation = propertyLocationService.update(id, propertyLocationDto);
            return ResponseEntity.ok(updatedPropertyLocation);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.valueOf(e instanceof NotFoundException ? "NOT_FOUND" : "BAD_REQUEST")).body(e.getMessage());
        }
    }
}
