import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Page} from "../../models/page/page";
import {HttpClient, HttpParams} from "@angular/common/http";
import {PropertySurfaceDto} from "../../models/propertysurface/propertySurfaceDto";

@Injectable({
  providedIn: 'root'
})
export class PropertysurfaceService {
  public host:string="http://localhost:8081"
  public api:string="/api/v1/surfaces/";
  constructor(private http:HttpClient) { }
  public getPages(pageNumber:number,size:number):Observable<Page<PropertySurfaceDto>>{
    const params = new HttpParams()
      .set('page', pageNumber).set('size',size);
    return this.http.get<Page<PropertySurfaceDto>>(this.host+this.api,{params});
  }
  public getList():Observable<Set<PropertySurfaceDto>>{
    return this.http.get<Set<PropertySurfaceDto>>(this.host+this.api+"all");
  }
}
