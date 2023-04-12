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
import {CityService} from "../../../../services/city/city.service";
import {ExteriorpropertyService} from "../../../../services/exteriorproperty/exteriorproperty.service";
import {CityDto} from "../../../../models/city/cityDto";
import {PropertyownerService} from "../../../../services/propertyowner/propertyowner.service";
import {InnerpropertyService} from "../../../../services/innerproperty/innerproperty.service";
import {PropertylocationService} from "../../../../services/propertylocation/propertylocation.service";
import {PropertysurfaceService} from "../../../../services/propertysurface/propertysurface.service";
import {PropertyenergiesService} from "../../../../services/propertyenergies/propertyenergies.service";

@Component({
  selector: 'app-add-property',
  templateUrl: './add-property.component.html',
  styleUrls: ['./add-property.component.css']
})
export class AddPropertyComponent implements OnInit {
  constructor(private propertyService:PropertyService,private router:Router,private route:ActivatedRoute
              ,private cityService:CityService,private exteriorPropertyService:ExteriorpropertyService,
              private ownerService:PropertyownerService,private interiorPropertyService:InnerpropertyService,
              private locationService:PropertylocationService,private surfaceService:PropertysurfaceService,
              private energyService:PropertyenergiesService
  ) { }
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
  propertyOwnerList:PropertyOwnerDto[]=[];
  propertySurfaceList:PropertySurfaceDto[]=[];
  innerPropertyList:InnerPropertyDto[]=[];
  propertyLocationList:PropertyLocationDto[]=[];
  exteriorPropertyList:ExteriorPropertyDto[]=[];
  propertyEnergiesList:PropertyEnergiesDto[]=[];
  cityList:CityDto[]=[];
  success: string = '';
  error: string = '';
  ngOnInit(): void {
    this.currentRoute.shift();
    this.cityService.getList().subscribe((data)=>{
      this.cityList = Array.from(data);
    });
    this.ownerService.getList().subscribe((data)=>{
      this.propertyOwnerList = Array.from(data);
    });
    this.locationService.getList().subscribe((data)=>{
      this.propertyLocationList = Array.from(data);
    });
    this.interiorPropertyService.getList().subscribe((data)=>{
      this.innerPropertyList = Array.from(data);
    });
    this.exteriorPropertyService.getList().subscribe((data)=>{
      this.exteriorPropertyList = Array.from(data);
    });
    this.surfaceService.getList().subscribe((data)=>{
      this.propertySurfaceList = Array.from(data);
    });
    this.energyService.getList().subscribe((data)=>{
      this.propertyEnergiesList = Array.from(data);
    });
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
  closeSuccess(){
    this.success = "";
    this.navigate("agent/properties");
  }
  onSubmit(){
    console.log(this.property);
    this.propertyService.add(this.property).subscribe((data)=>{
      this.success = "Property Added Successfully";
      setInterval(()=>{
        this.success = "";
        this.navigate("agent/properties");
      },1000*10);
    },(messageError) => {
      this.success = "";
      this.error = messageError.error;
      setInterval(()=>{
        this.error = "";
      },1000*10);
    });
  }
}
