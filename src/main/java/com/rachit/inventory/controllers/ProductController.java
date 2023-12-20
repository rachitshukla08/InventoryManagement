package com.rachit.inventory.controllers;

import com.rachit.inventory.data.Product;
import com.rachit.inventory.database.ProductsDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductsDB productsDB;

    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    public ResponseEntity<String> addProduct(@RequestBody Product product){
        if(product.getQuantity()>0) {
            boolean isAdded = productsDB.addProduct(product);
            if(!isAdded) {
                return new ResponseEntity<>("Product not added. Please enter valid product data", HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>("Product added. Quantity: "+ productsDB.getProduct(product.getId()).getQuantity(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Product not added. Please enter valid quantity", HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/delete/{id}" , method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteProduct(@PathVariable int id){
        Product deletedProduct = productsDB.deleteProduct(id);
        if(deletedProduct==null) {
            return new ResponseEntity<>("ID not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(deletedProduct, HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<String> updateProduct(@RequestBody Product product){
        boolean isUpdated = productsDB.updateProduct(product);
        if(!isUpdated) {
            return new ResponseEntity<>("No such product id found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Product updated successfully!", HttpStatus.OK);

    }

}
