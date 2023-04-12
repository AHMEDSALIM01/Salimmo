package org.propertyservice.controllers;

import lombok.RequiredArgsConstructor;
import org.propertyservice.dto.PropertyOwnerDto;
import org.propertyservice.services.PropertyOwnerService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/owners")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class PropertyOwnerController {

    private final PropertyOwnerService propertyOwnerService;

    @GetMapping("/{id}")
    public ResponseEntity<PropertyOwnerDto> findById(@PathVariable Long id) {
        PropertyOwnerDto ownerDto = propertyOwnerService.findById(id);
        return new ResponseEntity<>(ownerDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<PropertyOwnerDto>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<PropertyOwnerDto> ownersDto = propertyOwnerService.findAll(page, size);
        return new ResponseEntity<>(ownersDto, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PropertyOwnerDto>> findAll() {
        List<PropertyOwnerDto> ownersDto = propertyOwnerService.findAll();
        return new ResponseEntity<>(ownersDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PropertyOwnerDto> add(@RequestBody PropertyOwnerDto propertyOwnerRequestDto) {
        PropertyOwnerDto savedOwner = propertyOwnerService.add(propertyOwnerRequestDto);
        return new ResponseEntity<>(savedOwner, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PropertyOwnerDto> update(@PathVariable Long id, @RequestBody PropertyOwnerDto propertyOwnerRequestDto) {
        PropertyOwnerDto updatedOwner = propertyOwnerService.update(id, propertyOwnerRequestDto);
        return new ResponseEntity<>(updatedOwner, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOneById(@PathVariable Long id) {
        String message = propertyOwnerService.deleteOneById(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Map<String,String>> deleteMultipleById(@RequestBody List<Long> ids) {
        Map<String,String> messageMap = propertyOwnerService.deleteMultipleById(ids);
        return new ResponseEntity<>(messageMap, HttpStatus.OK);
    }
}