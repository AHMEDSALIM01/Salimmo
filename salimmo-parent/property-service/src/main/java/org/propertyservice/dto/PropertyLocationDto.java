package org.propertyservice.dto;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PropertyLocationDto {
    private Long id;
    //@JsonIgnoreProperties("propertyLocation")
    private PropertyDto property;
    private CityDto city;
    private int houseNumber;
    private String street;
    private String latitude;
    private String longitude;
}
