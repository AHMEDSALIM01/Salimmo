package org.propertyservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.propertyservice.enums.PropertyCategory;
import org.propertyservice.enums.PropertyType;

import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PropertyDto {
    private Long id;
    private UUID ref;
    @JsonIgnoreProperties("property")
    private PropertyOwnerDto owner;
    private PropertyCategory category;
    private PropertyType type;
    @JsonIgnoreProperties("property")
    private PropertyLocationDto propertyLocation;
    @JsonIgnoreProperties("property")
    private InnerPropertyDto innerProperty;
    @JsonIgnoreProperties("property")
    private PropertySurfaceDto propertySurface;
    @JsonIgnoreProperties("property")
    private PropertyEnergiesDto propertyEnergies;
    @JsonIgnoreProperties("property")
    private ExteriorPropertyDto exteriorProperty;
    private String title;
    private String description;
    private Double fees;
    private Double netPrice;
    private Byte [] images;
}
