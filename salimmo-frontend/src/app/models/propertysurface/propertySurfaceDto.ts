import {PropertyDto} from "../property/propertyDto";

export class PropertySurfaceDto {
  id!:number;
  property!:PropertyDto;
  livingArea!:number;
  groundSurface!:number;
  usefulSurface!:number;
  roofSpace!:number;
  squareArea!:number;
  gardenArea!:number;
  terraceArea!:number;
  balconyArea!:number;
  weightedArea!:number;
  ancillaryArea!:number;
  buildingArea!:number;
}
