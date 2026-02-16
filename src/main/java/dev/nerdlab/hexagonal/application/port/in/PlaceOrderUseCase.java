package dev.nerdlab.hexagonal.application.port.in;

import dev.nerdlab.hexagonal.domain.model.Order;

import java.util.UUID;

public interface PlaceOrderUseCase {

    UUID placeOrder(Order order);
    Order findById(String id);


}
