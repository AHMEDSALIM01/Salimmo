package org.propertyservice.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CityDto {
    private Long id;
    private String name;
    private String latitude;
    private String longitude;
}
