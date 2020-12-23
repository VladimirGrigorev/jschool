import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from "./component/login/login.component";
import {StoreBranchesComponent} from "./component/store-branches/store-branches.component";
import {SparePartsComponent} from "./component/spare-parts/spare-parts.component";
import {StoreBranchListComponent} from "./component/store-branch-list/store-branch-list.component";
import {SparePartsStoreBranchComponent} from "./component/spare-parts-store-branch/spare-parts-store-branch.component";
import {RegisterComponent} from "./component/register/register.component";
import {PurchasedSparePartsComponent} from "./component/purchased-spare-parts/purchased-spare-parts.component";

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'store-branches', component: StoreBranchesComponent},
  {path: 'spare-parts', component: SparePartsComponent},
  {path: 'store-branch-list', component: StoreBranchListComponent},
  {path: '', component: StoreBranchListComponent},
  {path: 'spare-parts/:id', component: SparePartsStoreBranchComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'purchased-spare-parts', component: PurchasedSparePartsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
