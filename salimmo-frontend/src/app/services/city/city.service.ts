import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Page} from "../../models/page/page";
import {PropertyDto} from "../../models/property/propertyDto";
import {HttpClient, HttpParams} from "@angular/common/http";
import {CityDto} from "../../models/city/cityDto";

@Injectable({
  providedIn: 'root'
})
export class CityService {
  public host:string="http://localhost:8081"
  public api:string="/api/v1/cities/";
  constructor(private http:HttpClient) { }
  public getAll(pageNumber:number,size:number):Observable<Page<CityDto>>{
    const params = new HttpParams()
      .set('page', pageNumber).set('size',size);
    return this.http.get<Page<CityDto>>(this.host+this.api,{params});
  }
}
