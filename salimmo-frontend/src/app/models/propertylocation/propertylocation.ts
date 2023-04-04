import {Property} from "../property/property";
import {City} from "../city/city";

export class Propertylocation {
  id!:number;
  property!:Property;
  city!:City;
  houseNumber!:number;
  street!:string;
  latitude!:string;
  longitude!:string;
}
