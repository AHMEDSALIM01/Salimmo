import { Injectable } from '@angular/core';
import {KeycloakInstance} from "keycloak-js";
import {HttpClient} from "@angular/common/http";
declare var Keycloak:any;
@Injectable({
  providedIn: 'root'
})
export class KeycloakSecurityService {
  public kc!:KeycloakInstance;
  constructor(private http:HttpClient) { }
  public async init(){
    this.kc = new Keycloak({
      url:"http://localhost:8080/",
      realm:"property-core",
      clientId:"cient_side_property"
    });
    // @ts-ignore
    await this.kc.init({
      onLoad:"login-required",
    });

   console.log(this.kc.token);
  }
}
