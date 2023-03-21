package org.propertyservice.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PropertySurface extends BaseEntity implements Serializable {
    @OneToOne(mappedBy = "propertySurface")
    private Property property;
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
