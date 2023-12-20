package com.rachit.inventory.events;

import org.springframework.context.ApplicationEvent;

public class ProductAddedEvent extends ApplicationEvent {

    private final int id;
    private final String name;

    public ProductAddedEvent(Object source, int id, String name) {
        super(source);
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
