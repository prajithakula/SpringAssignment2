package com.prajitha.productcalculation.service;

import com.prajitha.productcalculation.dto.ResponseModel;
import com.prajitha.productcalculation.model.Product;
import com.prajitha.productcalculation.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//Defining all methods for product controller
@Service
public class ProductService {

    //calling product service instance
    private final ProductRepository productRepository;

    //injecting product services using dependency injection
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //method for get all product details
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    //method for get product details by id
    public Product getProduct(int key) {
        return productRepository.findById(key).orElse(null);
    }

    //method for get product price process details by id,units
    public ResponseModel getProductPrice(int productId, int unit)
    {
        ResponseModel model = new ResponseModel();
        Product product = new Product();
        product = getProduct(productId);
        model.setName(product.getProductName());
        model.setProductId(product.getId());
        model.setCartons(cartonCount(unit,product.getInitialCartonCount()));
        model.setPrice(calculatePrice(productId,unit));
        model.setUnits(getUnits(unit,product.getInitialCartonCount()));

        return model;
    }
    //return the List of product details (25 product details) based on product id
    public List<ResponseModel> priceList(int productId){
        List<ResponseModel> list = new ArrayList<>();
        ResponseModel model = new ResponseModel();
        for (int i=1; i<=25;i++)
        {
            model = getProductPrice(productId,i);
            model.setTotalCount(i);
            list.add(model);
        }
        return list;
    }
    //method returns the price of the product along with productId, totalunits
    public double calculatePrice(int key, int purchaseCount){
        double totalPrice = 0;
        int cartonCount = 0;
        int totalsingleunitCount=0;
        Product product = new Product();
        product = getProduct(key);


        if(purchaseCount < product.getInitialCartonCount())
        {
            totalPrice = product.getSingleUnitPrice() * purchaseCount;
        }
        if(purchaseCount == product.getInitialCartonCount()){
            totalPrice = product.getInitialCartonPrice();
        }
        if(purchaseCount > product.getInitialCartonCount())
        {
            if(purchaseCount % product.getInitialCartonCount() == 0){
                cartonCount = purchaseCount / product.getInitialCartonCount();
                if(cartonCount >= 2) {
                    totalPrice = cartonCount * product.getDiscountCartonPrice();
                }
            }
            else{
                cartonCount = purchaseCount/product.getInitialCartonCount();
                totalsingleunitCount = purchaseCount % product.getInitialCartonCount();
                if(cartonCount >= 2) {
                    totalPrice = cartonCount * product.getDiscountCartonPrice() + totalsingleunitCount * product.getSingleUnitPrice();
                }
                else {
                    totalPrice = product.getInitialCartonPrice() + totalsingleunitCount * product.getSingleUnitPrice();
                }
            }
        }
        return totalPrice;
    }
    //method return the number of Carton along with unit and perCarton contain units
    public int cartonCount(int unit,int cartonContainUnit)
    {
        int count = unit/cartonContainUnit;
        return count;
    }
    //method return the single units except cartons(over the counts of carton range)
    public int getUnits(int unit,int cartonContainUnit){
        int count = unit % cartonContainUnit;
        return count;
    }
}
