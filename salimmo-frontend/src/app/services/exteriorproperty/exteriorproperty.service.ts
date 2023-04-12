import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Page} from "../../models/page/page";
import {HttpClient, HttpParams} from "@angular/common/http";
import {ExteriorPropertyDto} from "../../models/exteriorproperty/exteriorPropertyDto";

@Injectable({
  providedIn: 'root'
})
export class ExteriorpropertyService {
  public host:string="http://localhost:8081"
  public api:string="/api/v1/exteriors/";
  constructor(private http:HttpClient) {}
  public getPages(pageNumber:number,size:number):Observable<Page<ExteriorPropertyDto>>{
    const params = new HttpParams()
      .set('page', pageNumber).set('size',size);
    return this.http.get<Page<ExteriorPropertyDto>>(this.host+this.api,{params});
  }
  public getList():Observable<Set<ExteriorPropertyDto>>{
    return this.http.get<Set<ExteriorPropertyDto>>(this.host+this.api+"all");
  }
}
