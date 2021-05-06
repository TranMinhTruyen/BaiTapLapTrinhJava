import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'
import { FormsModule } from '@angular/forms';

//
import { MDBBootstrapModule } from 'angular-bootstrap-md';
//
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { ToastrModule } from 'ngx-toastr';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AdminComponent } from './admin/admin.component';
import { LoginComponent } from './admin/login/login.component';
import { SignupComponent } from './admin/signup/signup.component';
import { UserComponent } from './user/user.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavbarComponent } from './user/navbar/navbar.component';
import { HomeComponent } from './home/home.component';
import { LoaderComponent } from './home/loader/loader.component';
import { NavbarhomeComponent } from './home/navbarhome/navbarhome.component';
import { NotfoundComponent } from './notfound/notfound.component';
import { EmployeeComponent } from './admin/managerment/employee/employee.component';
import { AppbarssComponent } from './admin/appbarss/appbarss.component';
import { PersonalComponent } from './admin/managerment/personal/personal.component';

@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    LoginComponent,
    SignupComponent,
    UserComponent,
    NavbarComponent,
    HomeComponent,
    LoaderComponent,
    NavbarhomeComponent,
    NotfoundComponent,
    EmployeeComponent,
    AppbarssComponent,
    PersonalComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgbModule,
    ToastrModule.forRoot({
      timeOut: 10000,
      progressBar: true,
      progressAnimation: 'increasing'
    }),
    MatIconModule,
    MatButtonModule,
    MatToolbarModule,
    MDBBootstrapModule.forRoot(),
    BrowserAnimationsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
