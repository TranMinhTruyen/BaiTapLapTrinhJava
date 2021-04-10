import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { Notfound404Component } from './notfound404.component';

const routes: Routes = [
  { path: '404',
    component: Notfound404Component,
    // children:[{
    //   path: 'home',
    //   component: HomeComponent,
    // }]
  },
  { path: '**', component: Notfound404Component },
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
  ],
  exports: [RouterModule],
  declarations: [
    Notfound404Component
  ],
})
export class NotFoundRoutingModule { }
