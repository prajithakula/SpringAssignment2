import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Product } from '../models/Product';
import { Observable } from 'rxjs';
import { ProductDetails } from '../models/ProductDetails';
import { InputModel } from '../models/InputModel';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  readonly baseUrl = 'http://localhost:8081/api/';
  //readonly baseUrl = environment.apiUrl;
  productDetails? : ProductDetails[];
  product? : Product;
  input?: InputModel;
  productList? : Product[];
constructor(
  private http: HttpClient
) { 
 // this.input = new InputModel();
}

getAllProduct(): Observable<ProductDetails[]> {
  return this.http.get<ProductDetails[]>(this.baseUrl + 'product');
}
getProductPricedetails(key: number, count: number) : Observable<Product>{
  let params = new HttpParams();
  params = params.append('key',key);
  params = params.append('purchaseCount',count);
  return this.http.get<Product>(this.baseUrl + 'product/processPrice', {params: params});
}
getPriceList(key: number) : Observable<Product[]> {
  let params = new HttpParams();
  params = params.append('key',key);
  return this.http.get<Product[]>(this.baseUrl + 'product/priceList', {params: params});
}

}
