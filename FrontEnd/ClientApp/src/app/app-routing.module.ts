import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { LoginComponent } from './admin/login/login.component';
import { CalamviecComponent } from './admin/managerment/calamviec/calamviec.component';
import { CustomerComponent } from './admin/managerment/customer/customer.component';
import { EmployeeComponent } from './admin/managerment/employee/employee.component';
import { MenuComponent } from './admin/managerment/menu/menu.component';
import { PersonalComponent } from './admin/managerment/personal/personal.component';
import { PhanhoiComponent } from './admin/managerment/phanhoi/phanhoi.component';
import { ThucanComponent } from './admin/managerment/thucan/thucan.component';
import { TiecComponent } from './admin/managerment/tiec/tiec.component';
import { SignupComponent } from './admin/signup/signup.component';
import { HomeComponent } from './home/home.component';
import { NotfoundComponent } from './notfound/notfound.component';
import { DattiecComponent } from './user/func/dattiec/dattiec.component';
import { DattiecquanlyComponent } from './user/func/dattiecquanly/dattiecquanly.component';
import { FeedbackComponent } from './user/func/feedback/feedback.component';
import { LoginkhComponent } from './user/func/loginkh/loginkh.component';
import { MenucustomComponent } from './user/func/menucustom/menucustom.component';
import { ProfileComponent } from './user/func/profile/profile.component';
import { SignupkhComponent } from './user/func/signupkh/signupkh.component';
import { TimkiemComponent } from './user/func/timkiem/timkiem.component';
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
  { path: 'admin/tiec', component: TiecComponent },
  { path: 'admin/calamviec', component: CalamviecComponent },
  { path: 'admin/menu', component: MenuComponent },
  { path: 'admin/thucan', component: ThucanComponent },
  { path: 'admin/phanhoi', component: PhanhoiComponent },
  { path: 'user', component: UserComponent },
  { path: 'user/feedback', component: FeedbackComponent },
  { path: 'user/login', component:  LoginkhComponent},
  { path: 'user/signup', component:  SignupkhComponent},
  { path: 'user/profile', component:  ProfileComponent},
  { path: 'user/dattiec', component:  DattiecComponent},
  { path: 'user/quanlytiec', component:  DattiecquanlyComponent},
  { path: 'user/quanlymenu', component:  MenucustomComponent},
  { path: 'user/timkiem', component:  TimkiemComponent},
  { path: '**', redirectTo: '/404', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
