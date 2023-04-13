package org.propertyservice.controllers;

import lombok.RequiredArgsConstructor;
import org.hibernate.HibernateException;
import org.propertyservice.dto.PropertyDto;
import org.propertyservice.helpers.CriteriaFilter;
import org.propertyservice.services.PropertyService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/property")
@Validated
@CrossOrigin(origins = "*")
public class PropertyController {
    private final PropertyService propertyService;
    @GetMapping("/")
    public ResponseEntity<Object> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        try{
            Page<PropertyDto> propertyList = propertyService.findAll(page,size);
            return ResponseEntity.status(HttpStatus.OK).body(propertyList);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping("/filter")
    public ResponseEntity<Object> filter(@RequestBody CriteriaFilter criteriaFilter,@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        try{
            Page<PropertyDto> propertyList = propertyService.filter(criteriaFilter,page,size);
            return ResponseEntity.status(HttpStatus.OK).body(propertyList);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
    @GetMapping("/home")
    public ResponseEntity<Object> getRecommended(){
        try{
            List<PropertyDto> propertyList = propertyService.findRecommended();
            return ResponseEntity.ok().body(propertyList);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
    @GetMapping("{id}")
    public ResponseEntity<Object> getOneById(@PathVariable Long id){
        try {
            PropertyDto propertyDto = propertyService.findById(id);
                return ResponseEntity.accepted().body(propertyDto);
        }catch (Exception e){
            return ResponseEntity.status(e instanceof NotFoundException ? HttpStatus.NOT_FOUND : HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/")
    public ResponseEntity<Object> addOne(@RequestBody @Valid PropertyDto propertyRequestDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        try {
            PropertyDto propertyDto = propertyService.add(propertyRequestDto);
            if (propertyDto != null) {
                return ResponseEntity.accepted().body(propertyDto);
            }
            return ResponseEntity.badRequest().body("");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e instanceof HibernateException || e instanceof JpaSystemException ? "Error Adding property fields are unique" : e.getMessage());
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> updateOne(@PathVariable UUID id, @RequestBody @Valid PropertyDto propertyRequestDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        try {
            PropertyDto propertyDto = propertyService.update(id,propertyRequestDto);
            if (propertyDto != null) {
                return ResponseEntity.accepted().body(propertyDto);
            }
            return ResponseEntity.badRequest().body("");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteOne(@PathVariable Long id){
        try {
            PropertyDto propertyResponse = propertyService.deleteOneById(id);
            return ResponseEntity.ok().body(propertyResponse);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @DeleteMapping("/")
    public ResponseEntity<Object> deleteOMultiple(@RequestBody List<Long> ids){
        try {
            Map<String,String> propertyResponseList = propertyService.deleteMultipleById(ids);
            return ResponseEntity.status(HttpStatus.OK).body(propertyResponseList);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
