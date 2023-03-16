package org.propertyservice.dto.requestsdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.propertyservice.enums.HeatingType;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PropertyEnergiesRequestDto {
    private Long propertyId;
    private HeatingType heatingType;
    private String hotWater;
    private String electricalInstallation;
    private Double heatingLoads;
    private Double waterLoads;
    private Double electricLoads;
}
