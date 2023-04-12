import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {Page} from "../../models/page/page";
import {PropertyOwnerDto} from "../../models/propertyowner/propertyOwnerDto";

@Injectable({
  providedIn: 'root'
})
export class PropertyownerService {
  public host:string="http://localhost:8081"
  public api:string="/api/v1/owners/";
  constructor(private http:HttpClient) { }
  public getPages(pageNumber:number,size:number):Observable<Page<PropertyOwnerDto>>{
    const params = new HttpParams()
      .set('page', pageNumber).set('size',size);
    return this.http.get<Page<PropertyOwnerDto>>(this.host+this.api,{params});
  }
  public getList():Observable<Set<PropertyOwnerDto>>{
    return this.http.get<Set<PropertyOwnerDto>>(this.host+this.api+"all");
  }
}
