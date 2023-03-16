package org.propertyservice.dto.responsedto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class ExteriorPropertyResponseDto {
    private Long id;
    @JsonIgnoreProperties("exteriorProperty")
    private PropertyResponseDto property;
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
