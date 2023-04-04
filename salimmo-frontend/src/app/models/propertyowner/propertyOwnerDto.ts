import {PropertyDto} from "../property/propertyDto";

export class PropertyOwnerDto {
id!:number;
properties!:Set<PropertyDto>;
firstName!:string;
lastName!:string;
phone!:string;
}
