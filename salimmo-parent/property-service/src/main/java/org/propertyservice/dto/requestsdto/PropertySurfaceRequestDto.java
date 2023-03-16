package org.propertyservice.dto.requestsdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PropertySurfaceRequestDto {
    private Long propertyId;
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
