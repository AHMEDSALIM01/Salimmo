import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {PropertyService} from "../../../../services/property/property.service";
import {faCheck, faClose, faUpload, faHome} from "@fortawesome/free-solid-svg-icons";
import {faAdd} from "@fortawesome/free-solid-svg-icons/faAdd";
import {PropertyOwnerDto} from "../../../../models/propertyowner/propertyOwnerDto";
import {PropertyDto} from "../../../../models/property/propertyDto";
import {InnerPropertyDto} from "../../../../models/innerproperty/innerPropertyDto";
import {PropertyLocationDto} from "../../../../models/propertylocation/propertyLocationDto";
import {ExteriorPropertyDto} from "../../../../models/exteriorproperty/exteriorPropertyDto";
import {PropertySurfaceDto} from "../../../../models/propertysurface/propertySurfaceDto";
import {PropertyEnergiesDto} from "../../../../models/propertyenergies/propertyEnergiesDto";
import * as url from "url";

@Component({
  selector: 'app-add-property',
  templateUrl: './add-property.component.html',
  styleUrls: ['./add-property.component.css']
})
export class AddPropertyComponent implements OnInit {
  constructor(private propertyService:PropertyService,private router:Router,private route:ActivatedRoute) { }
  currentRoute:string[]=this.router.url.split("/");
  home=faHome;
  upload = faUpload;
  add = faAdd;
  close = faClose;
  valid =faCheck;
  addInnerProperty:boolean=false;
  addOwner:boolean = false;
  addPropertyLocation:boolean = false;
  addExteriorProperty:boolean = false;
  addSurface:boolean = false;
  addEnergy:boolean = false;
  owner:PropertyOwnerDto=new PropertyOwnerDto();
  property:PropertyDto=new PropertyDto();
  surface:PropertySurfaceDto=new PropertySurfaceDto();
  interiorProperty:InnerPropertyDto = new InnerPropertyDto();
  location:PropertyLocationDto = new PropertyLocationDto();
  exteriorProperty:ExteriorPropertyDto = new ExteriorPropertyDto();
  propertyEnergies:PropertyEnergiesDto= new PropertyEnergiesDto();
  ngOnInit(): void {
    this.currentRoute.shift()
  }
  confirmOwner(){
    this.property.owner=this.owner;
  }
  confirmLocation(){
    this.property.propertyLocation=this.location;
  }
  confirmInnerProperty(){
    this.property.innerProperty = this.interiorProperty;
  }
  confirmExteriorProperty(){
    this.property.exteriorProperty=this.exteriorProperty;
  }
  confirmPropertySurface(){
    this.property.propertySurface = this.surface;
  }
  confirmEnergy(){
    this.property.propertyEnergies = this.propertyEnergies;
  }
  navigate(path:string){
    this.router.navigate([path]);
  }
}
