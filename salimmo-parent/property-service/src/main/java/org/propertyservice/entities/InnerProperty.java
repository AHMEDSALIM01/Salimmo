package org.propertyservice.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class InnerProperty extends BaseEntity implements Serializable {
    @OneToOne(mappedBy = "innerProperty")
    private Property property;
    private int nbrOfLevels;
    private int nbrOfPieces;
    private int nbrOfRooms;
    private int nbrOfRoomsGroundFloor;
    private int nbrOfParentalRooms;
    private int nbrOfShowerRooms;
    private int nbrOfShowerRoomsGroundFloor;
    private int nbrOfBathrooms;
    private int nbrOfBathroomsGroundFloor;
    private int nbrOfToilets;
    private int nbrOfToiletsGroundFloor;
    private String kitchenType;
    private Boolean existingBasement;
    private Boolean existingWashRoom;
    private Boolean existingCave;
    private int nbrOfCaves;
    private Boolean existingCellar;
}
