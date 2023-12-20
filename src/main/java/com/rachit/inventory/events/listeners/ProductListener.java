package com.rachit.inventory.events.listeners;

import com.rachit.inventory.events.ProductAddedEvent;
import com.rachit.inventory.events.ProductDeletedEvent;
import com.rachit.inventory.events.ProductUpdatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ProductListener {

    @EventListener
    public void onProductAdded(ProductAddedEvent productAddedEvent){
        System.out.println("New product added: "+productAddedEvent.getId() +" "+productAddedEvent.getName());
    }

    @EventListener
    public void onProductUpdated(ProductUpdatedEvent productUpdatedEvent){
        System.out.println("Product updated: "+productUpdatedEvent.getId() +" "+productUpdatedEvent.getName());
    }

    @EventListener
    public void onProductDeleted(ProductDeletedEvent productDeletedEvent){
        System.out.println("Product deleted: "+productDeletedEvent.getId()+" "+productDeletedEvent.getName());
    }
}
