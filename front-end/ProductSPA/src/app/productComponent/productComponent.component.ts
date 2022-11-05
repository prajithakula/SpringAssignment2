import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Product } from '../models/Product';
import { ProductDetails } from '../models/ProductDetails';
import { AlertifyService } from '../services/alertify.service';
import { ProductService } from '../services/product.service';

@Component({
  selector: 'app-productComponent',
  templateUrl: './productComponent.component.html',
  styleUrls: ['./productComponent.component.css']
})
export class ProductComponentComponent implements OnInit {
  productDetails? : ProductDetails[];
  product? : Product;
  
  

  
  
  constructor(public service: ProductService, private alertify: AlertifyService, private router : Router) { }

  ngOnInit() {
    this.getAllProduct();
  }
  getAllProduct() {
    this.service.getAllProduct().subscribe(
      (Response: ProductDetails[]) => {
        this.productDetails = Response;
        console.log(Response);
      },
      error => {
        this.alertify.error(error);
      }
    );
  }
  onClickSubmit(data: any){
    this.getProductCalculation(data.prod,data.units)
  }
  getProductCalculation(key: number, count: number){
    this.service.getProductPricedetails(key,count).subscribe(
      (Response: Product) => {
        this.product= Response;
        console.log(this.product);
      }
    );
  }
  onClickHome(){
    this.router.navigate(['/home']);
  }

}
