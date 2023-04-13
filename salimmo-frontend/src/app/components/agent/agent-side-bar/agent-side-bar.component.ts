import { Component, OnInit } from '@angular/core';
import {faAreaChart, faBolt, faHomeAlt, faLocationDot, faUserAlt} from "@fortawesome/free-solid-svg-icons";
import {Router} from "@angular/router";

@Component({
  selector: 'app-agent-side-bar',
  templateUrl: './agent-side-bar.component.html',
  styleUrls: ['./agent-side-bar.component.css']
})
export class AgentSideBarComponent implements OnInit {
  home=faHomeAlt;
  user=faUserAlt;
  square=faAreaChart;
  location=faLocationDot;
  energy=faBolt;
  currentRout?:string;
  constructor(private router:Router) { }

  ngOnInit(): void {
    this.currentRout = this.router.url;
  }
}
