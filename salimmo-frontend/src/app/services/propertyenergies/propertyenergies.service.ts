import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {Page} from "../../models/page/page";
import {PropertyEnergiesDto} from "../../models/propertyenergies/propertyEnergiesDto";

@Injectable({
  providedIn: 'root'
})
export class PropertyenergiesService {
  public host:string="http://localhost:8081"
  public api:string="/api/v1/property-energies/";
  constructor(private http:HttpClient) { }
  public getPages(pageNumber:number,size:number):Observable<Page<PropertyEnergiesDto>>{
    const params = new HttpParams()
      .set('page', pageNumber).set('size',size);
    return this.http.get<Page<PropertyEnergiesDto>>(this.host+this.api,{params});
  }
  public getList():Observable<Set<PropertyEnergiesDto>>{
    return this.http.get<Set<PropertyEnergiesDto>>(this.host+this.api+"all");
  }
}
