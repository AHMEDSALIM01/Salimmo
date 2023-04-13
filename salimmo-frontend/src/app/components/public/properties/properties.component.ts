import { Component, OnInit } from '@angular/core';
import {PropertyDto} from "../../../models/property/propertyDto";
import {PropertyService} from "../../../services/property/property.service";
import {catchError, of} from "rxjs";
import {faSearch, faUndo} from "@fortawesome/free-solid-svg-icons";
import {CriteriaFilter} from "../../../models/criteria/criteria-filter";
import {PropertyStatus} from "../../../models/enums/property-status";
import {PropertyType} from "../../../models/enums/property-type";

@Component({
  selector: 'app-properties',
  templateUrl: './properties.component.html',
  styleUrls: ['./properties.component.css']
})
export class PropertiesComponent implements OnInit {
  public filter:CriteriaFilter=new CriteriaFilter();
  public properties:PropertyDto[]=[];
  public pageNumber:number=0;
  public hasNext = true;
  public hasPrevious = false;
  public loading = false;
  public size:number=10;
  search=faSearch
  reload=faUndo;
  noPropertyFound?:string;
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
  onSubmit(){
    console.log(this.filter);
    this.propertyService.filter(this.filter).subscribe((data)=>{
      if(data.totalElements>0){
        this.properties = data.content;
        this.hasNext = data.totalElements > (this.pageNumber * this.size);
      }else {
        this.properties = [];
        this.noPropertyFound="No Property Found";
      }
      console.log(data);
    });
    console.log(this.properties.length);
  }
  undo(){
    this.filter = new CriteriaFilter();
    this.noPropertyFound =undefined;
    this.ngOnInit();
  }
  isEmpty(filter:CriteriaFilter):boolean{
    return Object.keys(filter).length === 0;
  }

}
