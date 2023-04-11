import { Component, OnInit } from '@angular/core';
import {PropertyDto} from "../../../models/property/propertyDto";
import {PropertyService} from "../../../services/property/property.service";
import {catchError, of} from "rxjs";

@Component({
  selector: 'app-properties',
  templateUrl: './properties.component.html',
  styleUrls: ['./properties.component.css']
})
export class PropertiesComponent implements OnInit {
  public properties:PropertyDto[]=[];
  public pageNumber:number=0;
  public hasNext = true;
  public size:number=10;
  constructor(private propertyService:PropertyService) { }

  ngOnInit(): void {
    this.propertyService.getAllProperties(this.pageNumber, this.size).pipe(
      catchError(error => {
        console.error(error);
        return of(null);
      }),
    ).subscribe(pageData => {
      if (pageData) {
        this.properties = pageData.content;
        this.hasNext = pageData.totalElements > (this.pageNumber * this.size);
      }
      console.log(this.properties);
    });
  }
}
