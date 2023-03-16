package org.propertyservice.dto.requestsdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PropertyLocationRequestDto {
    private Long propertyId;
    private Long city;
    private int houseNumber;
    private String street;
    private String latitude;
    private String longitude;
}
