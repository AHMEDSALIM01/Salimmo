import {PropertyDto} from "../property/propertyDto";
import {CityDto} from "../city/cityDto";

export class PropertyLocationDto {
  id!:number;
  property!:PropertyDto;
  city!:CityDto;
  houseNumber!:number;
  street!:string;
  latitude!:string;
  longitude!:string;
}
