package org.propertyservice.dto;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class InnerPropertyDto {
    private Long id;
    //@JsonIgnoreProperties("innerProperty")
    private PropertyDto property;
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
