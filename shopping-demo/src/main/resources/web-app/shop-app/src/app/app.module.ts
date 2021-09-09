import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddSupplierComponent } from './supplier/add-supplier/add-supplier.component';
import { ListSuppliersComponent } from './supplier/list-suppliers/list-suppliers.component';
import {SupplierService} from "./supplier/supplier-service.service";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { LoginComponent } from './account/login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    AddSupplierComponent,
    ListSuppliersComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
  ],
  providers: [
    SupplierService,
    HttpClientModule
  ],
  bootstrap: [AppComponent],
  exports: [
    FormsModule,
    ReactiveFormsModule
  ]
})
export class AppModule { }
