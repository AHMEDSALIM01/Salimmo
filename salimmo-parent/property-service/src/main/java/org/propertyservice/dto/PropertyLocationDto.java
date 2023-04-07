package org.propertyservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PropertyLocationDto {
    private Long id;
    private PropertyDto property;
    @JsonIgnoreProperties("propertyLocation")
    private CityDto city;
    private int houseNumber;
    private String street;
    private String latitude;
    private String longitude;
}
