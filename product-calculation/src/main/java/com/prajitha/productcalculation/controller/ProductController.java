package com.prajitha.productcalculation.controller;

import com.prajitha.productcalculation.dto.ResponseModel;
import com.prajitha.productcalculation.model.Product;
import com.prajitha.productcalculation.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {

    //calling product service instance
    private final ProductService productService;

    //injecting product services using dependency injection
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //API endpoint for get all product details
    @GetMapping("")
    public List<Product> getAllProducts(){
        return this.productService.getAllProducts();
    }

    //API endpoint for get product details by id
    @GetMapping("{key}")
    public Product getProductById(@PathVariable int key){
        return productService.getProduct(key);
    }

    //API endpoint for calculate product price using product id and total purchase count
    @GetMapping("/processPrice")
    public ResponseModel processPrice(@RequestParam int key, @RequestParam int purchaseCount){
        return productService.getProductPrice(key, purchaseCount);
    }

    //API endpoint for list details of 25 units using product id
    @GetMapping("/priceList")
    public List<ResponseModel> priceList(@RequestParam int key){
        return productService.priceList(key);
    }
}
