import {PropertyOwner} from "../propertyowner/propertyOwner";
import {PropertyCategory} from "../enums/property-category";
import {PropertyType} from "../enums/property-type";
import {Propertylocation} from "../propertylocation/propertylocation";
import {Innerproperty} from "../innerproperty/innerproperty";
import {Propertysurface} from "../propertysurface/propertysurface";
import {Propertyenrgies} from "../propertyenergies/propertyenrgies";
import {Exteriorproperty} from "../exteriorproperty/exteriorproperty";

export class Property {
  id!:number;
  ref!:string;
  owner!:PropertyOwner;
  category!:PropertyCategory;
  type!:PropertyType;
  propertyLocation!:Propertylocation;
  innerProperty!:Innerproperty;
  propertySurface!:Propertysurface;
  propertyEnergies!:Propertyenrgies;
  exteriorProperty!:Exteriorproperty;
  title!:string;
  description!:string;
  fees!:number;
  netPrice!:number;
  images!:string[];
}
