import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from "./component/login/login.component";
import {StoreBranchesComponent} from "./component/store-branches/store-branches.component";
import {SparePartsComponent} from "./component/spare-parts/spare-parts.component";

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'store-branches', component: StoreBranchesComponent},
  {path: 'spare-parts', component: SparePartsComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
