import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {PropertiesComponent} from "./components/public/properties/properties.component";
import {HomeComponent} from "./components/public/home/home.component";
import {ClientComponent} from "./components/public/client/client.component";
import {DashboardComponent} from "./components/agent/dashboard/dashboard.component";
import {AgentPropertiesComponent} from "./components/agent/agent-properties/agent-properties.component";

const routes: Routes = [
  {
    path : "",
    component : ClientComponent,
    children : [
      {
        path : "properties",
        component : PropertiesComponent
      },
      {
        path : "",
        component : HomeComponent
      }
    ]
  },
  {
    path : "agent",
    component : DashboardComponent,
    children : [
      {
        path: "",
        component: AgentPropertiesComponent
      }
    ],
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
