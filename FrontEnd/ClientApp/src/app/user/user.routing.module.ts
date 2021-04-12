import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NavbarComponent } from './layouts/navbar/navbar.component'

import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatToolbarModule } from '@angular/material/toolbar';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './layouts/about/about.component';
import { PortfolioComponent } from './layouts/portfolio/portfolio.component';
import { FeedbackComponent } from './layouts/feedback/feedback.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { HomexComponent } from './layouts/homex/homex.component';

const routes: Routes = [
  { path: 'user',
    component: HomeComponent,
    // children:[{
    //   path: 'home',
    //   component: HomeComponent,
    // }]
  },
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
    MatButtonModule,
    MatIconModule,
    MatToolbarModule,
  ],
  exports: [RouterModule],
  declarations: [
    HomeComponent,
    NavbarComponent,
    AboutComponent,
    PortfolioComponent,
    FeedbackComponent,
    FooterComponent,
    HomexComponent
  ],
})
export class UserRoutingModule { }
