package org.propertyservice.dto;


import lombok.*;
import org.propertyservice.enums.HeatingType;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PropertyEnergiesDto {
    private Long id;
    private PropertyDto property;
    private HeatingType heatingType;
    private String hotWater;
    private String electricalInstallation;
    private Double heatingLoads;
    private Double waterLoads;
    private Double electricLoads;
}
