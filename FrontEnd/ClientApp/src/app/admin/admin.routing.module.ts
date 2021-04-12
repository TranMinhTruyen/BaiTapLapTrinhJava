import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin.component';
import { DashboardComponent } from './dashboard/dashboard.component';

const routes: Routes = [{
  path: 'admin',
  component: AdminComponent,
  children:[
    {
      path: 'dashboard',
      component: DashboardComponent,
    }
  ]
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  declarations: [DashboardComponent]
})
export class AdminRoutingModule { }