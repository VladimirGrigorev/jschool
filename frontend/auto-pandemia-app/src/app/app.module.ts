import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { LoginComponent } from './component/login/login.component';
import { StoreBranchesComponent } from './component/store-branches/store-branches.component';
import { SparePartsComponent } from './component/spare-parts/spare-parts.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    StoreBranchesComponent,
    SparePartsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
