package org.propertyservice.dto.responsedto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.propertyservice.entities.Property;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PropertySurfaceResponseDto {
    @JsonIgnoreProperties("propertySurface")
    private PropertyResponseDto property;
    private Double livingArea;
    private Double groundSurface;
    private Double usefulSurface;
    private Double roofSpace;
    private Double squareArea;
    private Double gardenArea;
    private Double terraceArea;
    private Double balconyArea;
    private Double weightedArea;
    private Double ancillaryArea;
    private Double buildingArea;
}
