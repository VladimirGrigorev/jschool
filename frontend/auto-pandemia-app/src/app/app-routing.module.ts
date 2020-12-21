import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from "./component/login/login.component";
import {StoreBranchesComponent} from "./component/store-branches/store-branches.component";

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'store-branches', component: StoreBranchesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
