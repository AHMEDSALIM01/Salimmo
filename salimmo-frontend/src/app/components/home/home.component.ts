import { Component, OnInit } from '@angular/core';
import {PropertyService} from "../../services/property/property.service";
import {PropertyDto} from "../../models/property/propertyDto";
import {catchError, of} from "rxjs";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  public properties:PropertyDto[]=[];
  public pageNumber:number=0;
  public hasNext = true;
  public size:number=10;
  constructor(private propertyService:PropertyService) {

  }

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
