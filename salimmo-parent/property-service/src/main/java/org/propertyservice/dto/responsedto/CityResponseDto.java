package org.propertyservice.dto.responsedto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CityResponseDto {
    private Long id;
    private String name;
    private String latitude;
    private String longitude;
}
