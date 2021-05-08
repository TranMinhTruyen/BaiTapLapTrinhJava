import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { LoginComponent } from './admin/login/login.component';
import { CustomerComponent } from './admin/managerment/customer/customer.component';
import { EmployeeComponent } from './admin/managerment/employee/employee.component';
import { PersonalComponent } from './admin/managerment/personal/personal.component';
import { SignupComponent } from './admin/signup/signup.component';
import { HomeComponent } from './home/home.component';
import { NotfoundComponent } from './notfound/notfound.component';
import { FeedbackComponent } from './user/func/feedback/feedback.component';
import { LoginkhComponent } from './user/func/loginkh/loginkh.component';
import { SignupkhComponent } from './user/func/signupkh/signupkh.component';
import { UserComponent } from './user/user.component';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: '404', component: NotfoundComponent },
  { path: 'home', component: HomeComponent },
  { path: 'admin', component: AdminComponent },
  { path: 'admin/login', component: LoginComponent },
  { path: 'admin/signup', component: SignupComponent },
  { path: 'admin/employee', component: EmployeeComponent },
  { path: 'admin/personal', component: PersonalComponent },
  { path: 'admin/customer', component: CustomerComponent },
  { path: 'user', component: UserComponent },
  { path: 'user/feedback', component: FeedbackComponent },
  { path: 'user/login', component:  LoginkhComponent},
  { path: 'user/signup', component:  SignupkhComponent},
  { path: '**', redirectTo: '/404', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
