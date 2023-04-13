import { Component, OnInit } from '@angular/core';
import {faSignIn, faSignOut, faSignOutAlt} from "@fortawesome/free-solid-svg-icons";
import {KeycloakSecurityService} from "../../../services/security/keycloak-security.service";

@Component({
  selector: 'app-agent-navbar',
  templateUrl: './agent-navbar.component.html',
  styleUrls: ['./agent-navbar.component.css']
})
export class AgentNavbarComponent implements OnInit {
  public modal:boolean=false;
  public isLoggedIn?:boolean=false;
  public signIcon=faSignIn
  signOut=faSignOutAlt;
  name!:string;
  email!:string;
  constructor(public keycloakService:KeycloakSecurityService) { }

  ngOnInit(): void {
    // @ts-ignore
    this.name =this.keycloakService.kc.tokenParsed['name'];
    // @ts-ignore
    this.email = this.keycloakService.kc.tokenParsed['email'];
    this.isLoggedIn = this.keycloakService.kc.authenticated;
  }


}
