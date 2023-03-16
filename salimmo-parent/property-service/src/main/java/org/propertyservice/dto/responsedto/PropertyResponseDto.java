package org.propertyservice.dto.responsedto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.propertyservice.entities.*;
import org.propertyservice.enums.PropertyCategory;
import org.propertyservice.enums.PropertyType;



@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PropertyResponseDto {
    @JsonIgnoreProperties("properties")
    private PropertyOwnerResponseDto owner;
    private PropertyCategory category;
    private PropertyType type;
    @JsonIgnoreProperties("property")
    private PropertyLocationResponseDto propertyLocation;
    @JsonIgnoreProperties("property")
    private InnerProperty innerProperty;
    @JsonIgnoreProperties("property")
    private PropertySurface propertySurface;
    @JsonIgnoreProperties("property")
    private PropertyEnergies propertyEnergies;
    @JsonIgnoreProperties("property")
    private ExteriorProperty exteriorProperty;
    private String title;
    private String description;
    private Double fees;
    private Double netPrice;
    private Byte [] images;
}
