package org.propertyservice.dto.responsedto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.propertyservice.entities.Property;
import org.propertyservice.enums.HeatingType;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PropertyEnergiesResponseDto {
    @JsonIgnoreProperties("propertyEnergies")
    private PropertyResponseDto property;
    private HeatingType heatingType;
    private String hotWater;
    private String electricalInstallation;
    private Double heatingLoads;
    private Double waterLoads;
    private Double electricLoads;
}
