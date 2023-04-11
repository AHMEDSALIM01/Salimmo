import {PropertyOwnerDto} from "../propertyowner/propertyOwnerDto";
import {PropertyCategory} from "../enums/property-category";
import {PropertyType} from "../enums/property-type";
import {PropertyLocationDto} from "../propertylocation/propertyLocationDto";
import {InnerPropertyDto} from "../innerproperty/innerPropertyDto";
import {PropertySurfaceDto} from "../propertysurface/propertySurfaceDto";
import {PropertyEnergiesDto} from "../propertyenergies/propertyEnergiesDto";
import {ExteriorPropertyDto} from "../exteriorproperty/exteriorPropertyDto";
import {PropertyStatus} from "../enums/property-status";

export class PropertyDto {
  id!:number;
  ref!:string;
  owner!:PropertyOwnerDto;
  category!:PropertyCategory;
  type!:PropertyType;
  propertyLocation!:PropertyLocationDto;
  innerProperty!:InnerPropertyDto;
  propertySurface!:PropertySurfaceDto;
  propertyEnergies!:PropertyEnergiesDto;
  exteriorProperty!:ExteriorPropertyDto;
  title!:string;
  description!:string;
  fees!:number;
  netPrice!:number;
  images!:string[];
  status!:PropertyStatus;
  createdAt!:Date;
}
