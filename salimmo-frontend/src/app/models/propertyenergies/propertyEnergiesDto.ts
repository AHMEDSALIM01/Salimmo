import {PropertyDto} from "../property/propertyDto";
import {HeatingType} from "../enums/heating-type";

export class PropertyEnergiesDto {
  id!:number;
  property!:PropertyDto;
  heatingType!:HeatingType;
  hotWater!:string;
  electricalInstallation!:string;
  heatingLoads!:number;
  waterLoads!:number;
  electricLoads!:number;
}
