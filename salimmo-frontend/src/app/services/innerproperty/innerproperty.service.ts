import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {Page} from "../../models/page/page";
import {InnerPropertyDto} from "../../models/innerproperty/innerPropertyDto";

@Injectable({
  providedIn: 'root'
})
export class InnerpropertyService {
  public host:string="http://localhost:8081"
  public api:string="/api/v1/innerproperties/";
  constructor(private http:HttpClient) { }
  public getPages(pageNumber:number,size:number):Observable<Page<InnerPropertyDto>>{
    const params = new HttpParams()
      .set('page', pageNumber).set('size',size);
    return this.http.get<Page<InnerPropertyDto>>(this.host+this.api,{params});
  }
  public getList():Observable<Set<InnerPropertyDto>>{
    return this.http.get<Set<InnerPropertyDto>>(this.host+this.api+"all");
  }
}
