import { Component, OnInit } from '@angular/core';
import {faSliders} from "@fortawesome/free-solid-svg-icons";

@Component({
  selector: 'app-side-bar',
  templateUrl: './side-bar.component.html',
  styleUrls: ['./side-bar.component.css']
})
export class SideBarComponent implements OnInit {
  filter=faSliders;
  constructor() { }

  ngOnInit(): void {
  }

}
