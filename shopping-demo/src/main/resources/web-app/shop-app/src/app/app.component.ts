import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {Supplier} from "./supplier/Supplier";
import {SupplierService} from "./supplier/supplier-service.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'shop-app';


  constructor(private router: Router) {
  }

  //TODO: Add login


  listSupplier(): void {
    this.router.navigate(['list-suppliers'])
      .then(e => console.log(e));
  }

  addSupplier(): void {
    this.router.navigate(['add-supplier'])
      .then((e) => {
        if (e) {
          console.log("Navigation is successful!");
        } else {
          console.log("Navigation has failed!");
        }
      });
  };

  ngOnInit(): void {

  }
}

