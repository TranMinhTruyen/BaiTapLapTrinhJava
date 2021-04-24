import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NavbarComponent } from './layouts/navbar/navbar.component'

import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatDialogModule } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatDatepickerModule } from '@angular/material/datepicker'; 
import { MatProgressBarModule } from '@angular/material/progress-bar'; 
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './layouts/about/about.component';
import { PortfolioComponent } from './layouts/portfolio/portfolio.component';
import { FeedbackComponent } from './layouts/feedback/feedback.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { HomexComponent } from './layouts/homex/homex.component';
import { SanhComponent } from './sanh/sanh.component';

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
    MatDialogModule,
    MatFormFieldModule,
    MatDatepickerModule,
    MatProgressBarModule
  ],
  exports: [RouterModule],
  declarations: [
    HomeComponent,
    NavbarComponent,
    AboutComponent,
    PortfolioComponent,
    FeedbackComponent,
    FooterComponent,
    HomexComponent,
    SanhComponent
  ],
  entryComponents:[SanhComponent]
})
export class UserRoutingModule { }
