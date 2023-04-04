package org.propertyservice.dto;

import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CityDto {
    private Long id;
    private Set<PropertyLocationDto> propertyLocation;
    private String name;
    private String latitude;
    private String longitude;
}
