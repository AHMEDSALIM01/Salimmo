package org.propertyservice.helpers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CriteriaFilter {
    private String city;
    private Double minPrice;
    private Double maxPrice;
    private int nbrOfRooms;
    private int nbOfBath;
    private String type;
}
