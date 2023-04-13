import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {PropertiesComponent} from "./components/public/properties/properties.component";
import {HomeComponent} from "./components/public/home/home.component";
import {ClientComponent} from "./components/public/client/client.component";
import {DashboardComponent} from "./components/agent/dashboard/dashboard.component";
import {AgentPropertiesComponent} from "./components/agent/agent-properties/agent-properties.component";
import {AddPropertyComponent} from "./components/agent/agent-properties/add-property/add-property.component";
import {
  AgentListPropertiesComponent
} from "./components/agent/agent-properties/agent-list-properties/agent-list-properties.component";
import {AuthGaurdService} from "./services/security/auth-gaurd.service";

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
        path: "", redirectTo :"properties",pathMatch:"full"
      },
      {
         path: "properties",
         component: AgentPropertiesComponent,
         children : [
           {
             path :"",
             component: AgentListPropertiesComponent
           },
           {
             path :"add",
             component : AddPropertyComponent
           }
         ],
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
