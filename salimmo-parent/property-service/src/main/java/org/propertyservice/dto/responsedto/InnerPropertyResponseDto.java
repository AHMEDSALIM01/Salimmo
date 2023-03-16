package org.propertyservice.dto.responsedto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.propertyservice.entities.Property;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class InnerPropertyResponseDto {
    @JsonIgnoreProperties("innerProperty")
    private PropertyResponseDto property;
    private int nbrOfLevels;
    private int nbrOfPieces;
    private int nbrOfRooms;
    private int nbrOfRoomsGroundFloor;
    private int nbrOfParentalRooms;
    private int nbrOfShowerRooms;
    private int nbrOfShowerRoomsGroundFloor;
    private int nbrOfBathrooms;
    private int nbrOfToilets;
    private int nbrOfToiletsGroundFloor;
    private String kitchenType;
    private Boolean existingBasement;
    private Boolean existingWashRoom;
    private Boolean existingCave;
    private int nbrOfCaves;
    private Boolean existingCellar;
}
