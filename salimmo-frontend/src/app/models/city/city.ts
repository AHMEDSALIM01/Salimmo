import {Propertylocation} from "../propertylocation/propertylocation";

export class City {
  id!:number;
  propertyLocation!:Set<Propertylocation>;
  name!:string;
  latitude!:string;
  longitude!:string;
}
