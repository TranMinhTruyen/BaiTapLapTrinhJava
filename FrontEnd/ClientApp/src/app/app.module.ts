import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AdminComponent } from './admin/admin.component';
import { UserComponent } from './user/user.component';
//
import { AdminRoutingModule } from './admin/admin.routing.module';
import { UserRoutingModule } from './user/user.routing.module';
import { Notfound404Component } from './notfound404/notfound404.component';


@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    UserComponent,
    Notfound404Component,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    AdminRoutingModule,
    UserRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
