package org.propertyservice.dto.responsedto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.propertyservice.entities.City;
import org.propertyservice.entities.Property;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PropertyLocationResponseDto {
    @JsonIgnoreProperties("propertyEnergies")
    private PropertyResponseDto property;
    private City city;
    private int houseNumber;
    private String street;
    private String latitude;
    private String longitude;
}
