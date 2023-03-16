package org.propertyservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class InnerProperty extends BaseEntity implements Serializable {
    @OneToOne(mappedBy = "innerProperty", optional = false)
    private Property property;
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
