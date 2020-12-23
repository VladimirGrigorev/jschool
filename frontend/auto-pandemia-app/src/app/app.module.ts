import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { LoginComponent } from './component/login/login.component';
import { StoreBranchesComponent } from './component/store-branches/store-branches.component';
import { SparePartsComponent } from './component/spare-parts/spare-parts.component';
import { StoreBranchListComponent } from './component/store-branch-list/store-branch-list.component';
import { SparePartsStoreBranchComponent } from './component/spare-parts-store-branch/spare-parts-store-branch.component';
import { RegisterComponent } from './component/register/register.component';
import {ToastrModule} from "ngx-toastr";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import { PurchasedSparePartsComponent } from './component/purchased-spare-parts/purchased-spare-parts.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    StoreBranchesComponent,
    SparePartsComponent,
    StoreBranchListComponent,
    SparePartsStoreBranchComponent,
    RegisterComponent,
    PurchasedSparePartsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ToastrModule.forRoot(),
    BrowserAnimationsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
