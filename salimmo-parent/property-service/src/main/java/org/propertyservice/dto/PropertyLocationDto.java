package org.propertyservice.dto;

import lombok.*;
import org.propertyservice.entities.City;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PropertyLocationDto {
    private Long id;
    //@JsonIgnoreProperties("propertyLocation")
    private PropertyDto property;
    private City city;
    private int houseNumber;
    private String street;
    private String latitude;
    private String longitude;
}
