import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {Page} from "../../models/page/page";
import {PropertyLocationDto} from "../../models/propertylocation/propertyLocationDto";

@Injectable({
  providedIn: 'root'
})
export class PropertylocationService {
  public host:string="http://localhost:8081"
  public api:string="/api/v1/locations/";
  constructor(private http:HttpClient) { }
  public getPages(pageNumber:number,size:number):Observable<Page<PropertyLocationDto>>{
    const params = new HttpParams()
      .set('page', pageNumber).set('size',size);
    return this.http.get<Page<PropertyLocationDto>>(this.host+this.api,{params});
  }
  public getList():Observable<Set<PropertyLocationDto>>{
    return this.http.get<Set<PropertyLocationDto>>(this.host+this.api+"all");
  }
}
