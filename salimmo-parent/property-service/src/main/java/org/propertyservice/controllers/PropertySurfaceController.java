package org.propertyservice.controllers;

import lombok.RequiredArgsConstructor;
import org.propertyservice.dto.PropertySurfaceDto;
import org.propertyservice.services.PropertySurfaceService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/surfaces")
@CrossOrigin(origins = "http://localhost:4200")
public class PropertySurfaceController {
    private final PropertySurfaceService propertySurfaceService;
    @GetMapping("")
    public ResponseEntity<Page<PropertySurfaceDto>> getAll(@RequestParam(defaultValue = "0") int page,
                                                               @RequestParam(defaultValue = "10") int size) {
        Page<PropertySurfaceDto> propertySurfaces = propertySurfaceService.findAll(page, size);
        return ResponseEntity.ok(propertySurfaces);
    }
    @GetMapping("/all")
    public ResponseEntity<List<PropertySurfaceDto>> getAll() {
        List<PropertySurfaceDto> propertySurfaces = propertySurfaceService.findAll();
        return ResponseEntity.ok(propertySurfaces);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id) {
        try {
            PropertySurfaceDto propertySurfaceDto = propertySurfaceService.findById(id);
            return ResponseEntity.status(HttpStatus.FOUND).body(propertySurfaceDto);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.valueOf(e instanceof NotFoundException ? "NOT_FOUND" : "BAD_REQUEST")).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> add(@RequestBody PropertySurfaceDto propertySurfaceDto) {

        try {
            PropertySurfaceDto savedPropertySurface = propertySurfaceService.add(propertySurfaceDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedPropertySurface);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody PropertySurfaceDto propertySurfaceDto) {
        try {
            PropertySurfaceDto updatedPropertySurface = propertySurfaceService.update(id, propertySurfaceDto);
            return ResponseEntity.ok(updatedPropertySurface);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.valueOf(e instanceof NotFoundException ? "NOT_FOUND" : "BAD_REQUEST")).body(e.getMessage());
        }
    }
}
