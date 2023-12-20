package com.rachit.inventory.database;

import com.rachit.inventory.data.Product;
import com.rachit.inventory.events.ProductAddedEvent;
import com.rachit.inventory.events.ProductDeletedEvent;
import com.rachit.inventory.events.ProductUpdatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class ProductsDB {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    HashMap<Integer, Product> allProducts;

    public HashMap<Integer, Product> getAllProducts() {
        return allProducts;
    }

    public ProductsDB(){
        this.allProducts = new HashMap<>();
    }

    public boolean addProduct(Product product){
        int id = product.getId();
        if(allProducts.containsKey(id)){
            Product p = allProducts.get(id);
            if(!p.equals(product)) {
                return false;
            }
            p.setQuantity(p.getQuantity()+product.getQuantity());
        }
        else {
            allProducts.put(id, product);
        }
        eventPublisher.publishEvent(new ProductAddedEvent(this, id, product.getName()));
        return true;
    }

    public Product getProduct(int id){
        return allProducts.getOrDefault(id, null);
    }

    public Product deleteProduct(int id){
        if(allProducts.containsKey(id)){
            eventPublisher.publishEvent(new ProductDeletedEvent(this, id, allProducts.get(id).getName()));
            return allProducts.remove(id);
        }
        return null;
    }

    public boolean updateProduct(Product product) {
        if(allProducts.containsKey(product.getId())){
            allProducts.put(product.getId(), product);
            eventPublisher.publishEvent(new ProductUpdatedEvent(this, product.getId(), product.getName()));
            return true;
        }
        return false;
    }
}
