import {PropertyLocationDto} from "../propertylocation/propertyLocationDto";

export class CityDto {
  id!:number;
  propertyLocation!:Set<PropertyLocationDto>;
  name!:string;
  latitude!:string;
  longitude!:string;
}
