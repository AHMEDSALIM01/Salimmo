package org.propertyservice.controllers;

import lombok.RequiredArgsConstructor;
import org.propertyservice.dto.ExteriorPropertyDto;
import org.propertyservice.services.ExteriorPropertyService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/exteriors")
@CrossOrigin(origins = "*")
public class ExteriorPropertyController {

    private final ExteriorPropertyService exteriorService;

    @GetMapping("/{id}")
    public ResponseEntity<ExteriorPropertyDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(exteriorService.findById(id));
    }

    @GetMapping
    public ResponseEntity<Page<ExteriorPropertyDto>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(exteriorService.findAll(page, size));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ExteriorPropertyDto>> findAll(){
        return ResponseEntity.ok(exteriorService.findAll());
    }

    @PostMapping
    public ResponseEntity<ExteriorPropertyDto> add(@RequestBody ExteriorPropertyDto exteriorDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(exteriorService.add(exteriorDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExteriorPropertyDto> update(
            @PathVariable Long id,
            @RequestBody ExteriorPropertyDto requestDto) {
        return ResponseEntity.ok(exteriorService.update(id, requestDto));
    }
}
