import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AddSupplierComponent} from "./supplier/add-supplier/add-supplier.component";
import {ListSuppliersComponent} from "./supplier/list-suppliers/list-suppliers.component";
import {LoginComponent} from "./account/login/login.component";

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'list-suppliers', component: ListSuppliersComponent},
  {path: 'add-supplier', component: AddSupplierComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
