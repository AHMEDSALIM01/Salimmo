package org.propertyservice.controllers;

import lombok.RequiredArgsConstructor;
import org.propertyservice.dto.PropertyEnergiesDto;
import org.propertyservice.services.PropertyEnergiesService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/property-energies")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class PropertyEnergiesController {
    private final PropertyEnergiesService propertyEnergiesService;

    @GetMapping("/{id}")
    public ResponseEntity<PropertyEnergiesDto> findById(@PathVariable Long id) {
        PropertyEnergiesDto propertyEnergies = propertyEnergiesService.findById(id);
        return ResponseEntity.ok(propertyEnergies);
    }

    @GetMapping
    public ResponseEntity<Page<PropertyEnergiesDto>> findAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Page<PropertyEnergiesDto> propertyEnergiesList = propertyEnergiesService.findAll(page, size);
        return ResponseEntity.ok(propertyEnergiesList);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PropertyEnergiesDto>> findAll() {
        List<PropertyEnergiesDto> propertyEnergiesList = propertyEnergiesService.findAll();
        return ResponseEntity.ok(propertyEnergiesList);
    }

    @PostMapping
    public ResponseEntity<PropertyEnergiesDto> add(@RequestBody PropertyEnergiesDto propertyEnergiesDto) {
        PropertyEnergiesDto savedPropertyEnergies = propertyEnergiesService.add(propertyEnergiesDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPropertyEnergies);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PropertyEnergiesDto> update(@PathVariable Long id, @RequestBody PropertyEnergiesDto propertyEnergiesDto) {
        PropertyEnergiesDto updatedPropertyEnergies = propertyEnergiesService.update(id, propertyEnergiesDto);
        return ResponseEntity.ok(updatedPropertyEnergies);
    }
}