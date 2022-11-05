import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ProductSPA';

  constructor( private router : Router) {}

  onClickHome(){
    this.router.navigate(['/home']);
  }
  onClickProduct(){
    this.router.navigate(['/products']);
  }
  onClickUser(){
    this.router.navigate(['/user']);
  }
}


