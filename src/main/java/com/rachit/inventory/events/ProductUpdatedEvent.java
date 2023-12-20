package com.rachit.inventory.events;

import org.springframework.context.ApplicationEvent;

public class ProductUpdatedEvent extends ApplicationEvent {
    private final int id;
    private final String name;


    public ProductUpdatedEvent(Object source, int id, String name) {
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
