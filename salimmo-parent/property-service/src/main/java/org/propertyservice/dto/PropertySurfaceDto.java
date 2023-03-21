package org.propertyservice.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PropertySurfaceDto {
    private Long id;
    //@JsonIgnoreProperties("propertySurface")
    private PropertyDto property;
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
