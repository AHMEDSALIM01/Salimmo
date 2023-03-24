package org.propertyservice.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ExteriorPropertyDto {
    private Long id;
    private PropertyDto property;
    @DateTimeFormat(pattern = "yyyy")
    private Date yearConstruction;
    private String windows;
    private String shutter;
    private String roof;
    private Boolean sewer;
    private String condition;
    private Boolean existingGarage;
    private int nbrOfGarage;
    private String fence;
    private Boolean terrace;
    private Boolean piscine;
}
