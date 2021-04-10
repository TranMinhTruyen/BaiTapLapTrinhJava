import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { UserComponent } from './user.component';
import { NavbarComponent } from './layouts/navbar/navbar.component'

import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatToolbarModule } from '@angular/material/toolbar';

const routes: Routes = [
  { path: 'user',
    component: UserComponent,
    // children:[{
    //   path: 'home',
    //   component: HomeComponent,
    // }]
  },
  { path: 'user/home',
    // redirectTo: 'home',
    // pathMatch:'full'
    component: HomeComponent,
  },
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
    MatButtonModule,
    MatIconModule,
    MatToolbarModule
  ],
  exports: [RouterModule],
  declarations: [
    HomeComponent,
    NavbarComponent
  ],
})
export class UserRoutingModule { }
