package org.propertyservice.dto.requestsdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.propertyservice.enums.PropertyCategory;
import org.propertyservice.enums.PropertyType;

import javax.validation.constraints.NotNull;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PropertyRequestDto {
   // private PropertyOwnerResponseDto owner;
    private PropertyCategory category;
    private PropertyType type;
    //private PropertyLocationResponseDto propertyLocation;
    //private InnerPropertyResponseDto innerProperty;
    //private PropertySurfaceResponseDto propertySurface;
    //private PropertyEnergiesResponseDto propertyEnergies;
   // private ExteriorPropertyResponseDto exteriorProperty;
    @NotNull
    private String title;
    @NotNull
    private String description;
    @NotNull
    private Double fees;
    @NotNull
    private Double netPrice;
    private Byte [] images;
}
