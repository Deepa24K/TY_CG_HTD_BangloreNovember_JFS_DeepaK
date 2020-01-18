import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {
  selectedProductToUpdate: Products;

  api = `http://localhost:8080`;

  constructor(private http: HttpClient) { }
  postData(product): Observable<any> {
    return this.http.post<any>(
      `${this.api}/products/add-product`,
      product);
  }
  getData(): Observable<Products[]> {
    return this.http.get<Products[]>(`${this.api}/products/get-products`);
  }
  deleteData(product: Products): Observable<any> {
    return this.http.delete<any>(
      `${this.api}/products/delete-product/${product.productName}`,
    );
  }
}
