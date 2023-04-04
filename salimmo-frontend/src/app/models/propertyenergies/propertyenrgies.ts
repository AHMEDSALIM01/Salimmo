import {Property} from "../property/property";
import {HeatingType} from "../enums/heating-type";

export class Propertyenrgies {
  id!:number;
  property!:Property;
  heatingType!:HeatingType;
  hotWater!:string;
  electricalInstallation!:string;
  heatingLoads!:number;
  waterLoads!:number;
  electricLoads!:number;
}
