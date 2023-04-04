import {Property} from "../property/property";

export class Innerproperty {
  id!:number;
  property!:Property;
  nbrOfLevels!:number;
  nbrOfPieces!:number;
  nbrOfRooms!:number;
  nbrOfRoomsGroundFloor!:number;
  nbrOfParentalRooms!:number;
  nbrOfShowerRooms!:number;
  nbrOfShowerRoomsGroundFloor!:number;
  nbrOfBathrooms!:number;
  nbrOfBathroomsGroundFloor!:number;
  nbrOfToilets!:number;
  nbrOfToiletsGroundFloor!:number;
  kitchenType!:string;
  existingBasement!:boolean;
  existingWashRoom!:boolean;
  existingCave!:boolean;
  nbrOfCaves!:number;
  existingCellar!:boolean;
}
