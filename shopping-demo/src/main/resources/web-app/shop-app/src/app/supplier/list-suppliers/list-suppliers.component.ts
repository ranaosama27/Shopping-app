import { Component, OnInit } from '@angular/core';
import {SupplierService} from "../supplier-service.service";
import {Supplier} from "../Supplier";

@Component({
  selector: 'app-list-suppliers',
  templateUrl: './list-suppliers.component.html',
  styleUrls: ['./list-suppliers.component.scss']
})
export class ListSuppliersComponent implements OnInit {
  suppliers: Supplier[] = [];
  constructor(private SupplierService: SupplierService) {
  }

  ngOnInit(): void {
      this.getSuppliers();
  }

  getSuppliers() {
    this.SupplierService.getSuppliers().subscribe(data => {
      this.suppliers = data;
    });
  }

}
