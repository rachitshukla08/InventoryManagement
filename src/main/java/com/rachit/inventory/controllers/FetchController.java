package com.rachit.inventory.controllers;

import com.rachit.inventory.data.Product;
import com.rachit.inventory.database.ProductsDB;
import com.rachit.inventory.manager.FetchProductsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@RequestMapping("/view-products")
@Controller
public class FetchController {

    @Autowired
    ProductsDB productsDB;

    @GetMapping
    public ResponseEntity<?> getFilteredProducts(@RequestParam(required = false, value = "name") String name,
                                                 @RequestParam(required = false, value = "brand") String brand,
                                                 @RequestParam(required = false, value = "category") String category){

        HashMap<Integer, Product> shallowCopy = new HashMap<>(productsDB.getAllProducts());
        if(name!=null){
            shallowCopy = (HashMap<Integer, Product>) FetchProductsManager.getByName(shallowCopy, name);
        }
        if(brand!=null){
            shallowCopy = (HashMap<Integer, Product>) FetchProductsManager.getByBrand(shallowCopy, brand);
        }
        if(category!=null){
            shallowCopy = (HashMap<Integer, Product>) FetchProductsManager.getByCategory(shallowCopy, category);
        }

        return new ResponseEntity<>(shallowCopy, HttpStatus.OK);
    }


}
