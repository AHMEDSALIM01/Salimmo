import {PropertyDto} from "../property/propertyDto";

export class PropertySurfaceDto {
  id!:number;
  property!:PropertyDto;
  livingArea!:number;
  groundSurface!:number;
  usefulSurface!:number;
  roofSpace!:number;
}
