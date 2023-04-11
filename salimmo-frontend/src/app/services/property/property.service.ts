import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpParams, HttpResponse} from "@angular/common/http";
import {PropertyDto} from "../../models/property/propertyDto";
import {Observable} from "rxjs";
import {Page} from "../../models/page/page";

@Injectable({
  providedIn: 'root'
})
export class PropertyService {
  public host:string="http://localhost:8081"
  public api:string="/api/v1/property/";
  constructor(private http:HttpClient) { }
  public getAllProperties(pageNumber:number,size:number):Observable<Page<PropertyDto>>{
    const params = new HttpParams()
      .set('page', pageNumber).set('size',size);
    return this.http.get<Page<PropertyDto>>(this.host+this.api,{params});
  }
  public getRecommendedProperties():Observable<Set<PropertyDto>>{
    return this.http.get<Set<PropertyDto>>(this.host+this.api+"home");
  }
  public delete(id:number):Observable<PropertyDto>{
    return this.http.delete<PropertyDto>(this.host+this.api+id);
  }
}
