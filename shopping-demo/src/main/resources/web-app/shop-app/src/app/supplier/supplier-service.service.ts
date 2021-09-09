import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SupplierService {

  private url = 'http://localhost:8080/api/suppliers';
  constructor(private http: HttpClient) {
  }

  getSuppliers(): Observable<any> {
    return this.http.get(`${this.url}`);
  }

  addSupplier(book: Object): Observable<Object> {
    return this.http.post(`${this.url}`, book);
  }
}
