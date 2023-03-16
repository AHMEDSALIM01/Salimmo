package org.propertyservice.dto.requestsdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ExteriorPropertyRequestDto {
    private Long propertyId;
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
