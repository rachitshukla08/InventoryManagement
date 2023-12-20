package com.rachit.inventory.data;

import java.util.Objects;

public class Product {
    private int id;
    private String name;
    private String category;
    private String brand;
    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Product p)) return false;
        return p.getId() == this.getId()
                && Objects.equals(p.getName(), this.getName())
                && Objects.equals(p.getBrand(), this.getBrand())
                && Objects.equals(p.getCategory(), this.getCategory());
    }
}
