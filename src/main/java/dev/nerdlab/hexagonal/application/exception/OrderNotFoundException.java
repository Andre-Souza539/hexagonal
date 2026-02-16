package dev.nerdlab.hexagonal.application.exception;

import java.util.UUID;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(UUID uuid) {
        super("Order not found with Id: " + uuid);
    }
}
