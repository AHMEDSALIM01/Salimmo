import { Component, OnInit } from '@angular/core';
import {PropertyService} from "../../../services/property/property.service";
import {PropertyDto} from "../../../models/property/propertyDto";
import {Router} from "@angular/router";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  public properties:PropertyDto[]=[];
  constructor(private propertyService:PropertyService,private router:Router) {

  }

  ngOnInit(): void {
      this.propertyService.getRecommendedProperties().subscribe((data)=>{
        this.properties = Array.from(data);
      })
  }
  navigate(path:string){
    this.router.navigate([path]);
  }
}
