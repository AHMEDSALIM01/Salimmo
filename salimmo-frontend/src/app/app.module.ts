import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PropertiesComponent } from './components/public/properties/properties.component';
import { LoginComponent } from './components/public/login/login.component';
import { RegisterComponent } from './components/public/register/register.component';
import { ClientNavbarComponent } from './components/public/clientnavbar/client-navbar.component';
import { FooterComponent } from './components/footer/footer.component';
import { HomeComponent } from './components/public/home/home.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import { SideBarComponent } from './components/public/properties/side-bar/side-bar.component';
import { FilterComponent } from './components/public/properties/filter/filter.component';
import { ClientComponent } from './components/public/client/client.component';
import { DashboardComponent } from './components/agent/dashboard/dashboard.component';
import {AgentNavbarComponent} from "./components/agent/agentnavbar/agent-navbar.component";
import { AgentSideBarComponent } from './components/agent/agent-side-bar/agent-side-bar.component';
import { AgentPropertiesComponent } from './components/agent/agent-properties/agent-properties.component';
@NgModule({
  declarations: [
    AppComponent,
    PropertiesComponent,
    LoginComponent,
    RegisterComponent,
    ClientNavbarComponent,
    FooterComponent,
    HomeComponent,
    SideBarComponent,
    FilterComponent,
    ClientComponent,
    DashboardComponent,
    AgentNavbarComponent,
    AgentSideBarComponent,
    AgentPropertiesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
