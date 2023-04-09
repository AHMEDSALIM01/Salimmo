import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-agent-navbar',
  templateUrl: './agent-navbar.component.html',
  styleUrls: ['./agent-navbar.component.css']
})
export class AgentNavbarComponent implements OnInit {
  public modal:boolean=false;
  constructor() { }

  ngOnInit(): void {
  }

}
