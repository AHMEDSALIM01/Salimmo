package org.propertyservice.dto.requestsdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.propertyservice.dto.responsedto.*;
import org.propertyservice.entities.*;
import org.propertyservice.enums.PropertyCategory;
import org.propertyservice.enums.PropertyType;



@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PropertyRequestDto {
    private PropertyOwnerResponseDto owner;
    private PropertyCategory category;
    private PropertyType type;
    private PropertyLocationResponseDto propertyLocation;
    private InnerPropertyResponseDto innerProperty;
    private PropertySurfaceResponseDto propertySurface;
    private PropertyEnergiesResponseDto propertyEnergies;
    private ExteriorPropertyResponseDto exteriorProperty;
    private String title;
    private String description;
    private Double fees;
    private Double netPrice;
    private Byte [] images;
}
