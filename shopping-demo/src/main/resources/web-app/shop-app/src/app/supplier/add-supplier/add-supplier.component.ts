import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {SupplierService} from "../supplier-service.service";

@Component({
  selector: 'app-add-supplier',
  templateUrl: './add-supplier.component.html',
  styleUrls: ['./add-supplier.component.scss']
})
export class AddSupplierComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private router: Router, private supplierService: SupplierService) {
  }

  addForm: FormGroup = this.formBuilder.group({id: [], name: [''], phoneNumber: ['']});
  message: string = "";
  ngOnInit() {
    this.addForm = this.formBuilder.group({
      id: [],
      name: ['', Validators.required],
      phoneNumber: ['', Validators.required]
    });

  }

  onSubmit() {
    this.supplierService.addSupplier(this.addForm.value)
      .subscribe((data:any) => {
        this.message = data.message;
        this.router.navigate(['list-suppliers']);
      });
  }


}
