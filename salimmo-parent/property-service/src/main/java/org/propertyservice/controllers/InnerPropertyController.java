package org.propertyservice.controllers;



import lombok.RequiredArgsConstructor;
import org.propertyservice.dto.InnerPropertyDto;
import org.propertyservice.services.InnerPropertyService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/innerproperties")
@RequiredArgsConstructor
public class InnerPropertyController {

    private final InnerPropertyService innerPropertyService;

    @GetMapping("/{id}")
    public ResponseEntity<InnerPropertyDto> findById(@PathVariable Long id) {
        InnerPropertyDto innerPropertyDto = innerPropertyService.findById(id);
        return new ResponseEntity<>(innerPropertyDto, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Page<InnerPropertyDto>> findAll(@RequestParam(defaultValue = "0") int page,
                                                          @RequestParam(defaultValue = "20") int size) {
        Page<InnerPropertyDto> innerPropertyResponseDtoPage = innerPropertyService.findAll(page, size);
        return new ResponseEntity<>(innerPropertyResponseDtoPage, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<InnerPropertyDto> add(@RequestBody InnerPropertyDto innerPropertyRequestDto) {
        InnerPropertyDto innerPropertyDto = innerPropertyService.add(innerPropertyRequestDto);
        return new ResponseEntity<>(innerPropertyDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InnerPropertyDto> update(@PathVariable Long id,
                                                   @RequestBody InnerPropertyDto innerPropertyRequestDto) {
        InnerPropertyDto updatedInnerProperty = innerPropertyService.update(id, innerPropertyRequestDto);
        return new ResponseEntity<>(updatedInnerProperty, HttpStatus.OK);
    }
}
