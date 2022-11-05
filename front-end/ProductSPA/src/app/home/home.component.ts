import { Component, OnInit } from '@angular/core';
import { Product } from '../models/Product';
import { ProductDetails } from '../models/ProductDetails';
import { AlertifyService } from '../services/alertify.service';
import { ProductService } from '../services/product.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  productDetails? : Product[];
  product? : ProductDetails[];
  data: any;
  constructor(public service: ProductService, private alertify: AlertifyService) { }

  ngOnInit() {
   // this.getPriceList(1);
   this.getAllProduct();
  }
  onClickSubmit(data: any){
    this.getPriceList(data.prod)
  }
  getAllProduct() {
    this.service.getAllProduct().subscribe(
      (Response: ProductDetails[]) => {
        this.product = Response;
        console.log(this.product);
      },
      error => {
        this.alertify.error(error);
      }
    );
  }
  getPriceList(key: number){
    this.service.getPriceList(key).subscribe(
      (Response: Product[]) => {
        this.productDetails= Response;
        console.log(this.productDetails);
      }
    );
  }
}
