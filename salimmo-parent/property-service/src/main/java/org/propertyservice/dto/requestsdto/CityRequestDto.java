package org.propertyservice.dto.requestsdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CityRequestDto {
    private String name;
    private String latitude;
    private String longitude;
}
