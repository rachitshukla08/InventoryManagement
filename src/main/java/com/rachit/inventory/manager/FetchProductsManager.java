package com.rachit.inventory.manager;

import com.rachit.inventory.data.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FetchProductsManager {


    public static Map<Integer, Product> getByName(HashMap<Integer, Product> filteredProducts, String name){
        return filteredProducts
                .entrySet()
                .stream()
                .filter(e -> e.getValue().getName().equalsIgnoreCase(name))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static Map<Integer, Product> getByCategory(HashMap<Integer, Product> filteredProducts, String category){
        return filteredProducts
                .entrySet()
                .stream()
                .filter(e -> e.getValue().getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static Map<Integer, Product> getByBrand(HashMap<Integer, Product> filteredProducts, String brand){
        return filteredProducts
                .entrySet()
                .stream()
                .filter(e -> e.getValue().getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

}
