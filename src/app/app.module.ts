import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

//
import { MDBBootstrapModule } from 'angular-bootstrap-md';
//
import { MatListModule } from '@angular/material/list'
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatMenuModule } from '@angular/material/menu';
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
import { CustomerComponent } from './admin/managerment/customer/customer.component';
import { FeedbackComponent } from './user/func/feedback/feedback.component';
import { SignupkhComponent } from './user/func/signupkh/signupkh.component';
import { LoginkhComponent } from './user/func/loginkh/loginkh.component';
import { ManagermentComponent } from './admin/managerment/managerment.component';
import { TiecComponent } from './admin/managerment/tiec/tiec.component';
import { DattiecComponent } from './user/func/dattiec/dattiec.component';
import { DattiecquanlyComponent } from './user/func/dattiecquanly/dattiecquanly.component';
import { MenucustomComponent } from './user/func/menucustom/menucustom.component';
import { CalamviecComponent } from './admin/managerment/calamviec/calamviec.component';
import { ProfileComponent } from './user/func/profile/profile.component';
import { TimkiemComponent } from './user/func/timkiem/timkiem.component';

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
    PersonalComponent,
    CustomerComponent,
    FeedbackComponent,
    SignupkhComponent,
    LoginkhComponent,
    ManagermentComponent,
    TiecComponent,
    DattiecComponent,
    DattiecquanlyComponent,
    MenucustomComponent,
    CalamviecComponent,
    ProfileComponent,
    TimkiemComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    MatMenuModule,
    NgbModule,
    ToastrModule.forRoot({
      timeOut: 10000,
      progressBar: true,
      progressAnimation: 'increasing'
    }),
    MatIconModule,
    MatListModule,
    MatButtonModule,
    MatToolbarModule,
    MatSidenavModule,
    MDBBootstrapModule.forRoot(),
    BrowserAnimationsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
