import { Component, OnInit } from '@angular/core';
import {faSignIn} from "@fortawesome/free-solid-svg-icons";
import {Router} from "@angular/router";
import {KeycloakSecurityService} from "../../../services/security/keycloak-security.service";

@Component({
  selector: 'app-navbar',
  templateUrl: './client-navbar.component.html',
  styleUrls: ['./client-navbar.component.css']
})
export class ClientNavbarComponent implements OnInit {
  public modal:boolean=false;
  isLoggedIn?: boolean=false;
  signIcon=faSignIn;
  currentRoute?:string;
  name?:string;
  constructor(private router:Router,public keycloakService:KeycloakSecurityService) { }

  ngOnInit(): void {
    this.currentRoute = this.router.url;
    this.isLoggedIn = this.keycloakService.kc.authenticated;
  }

}
