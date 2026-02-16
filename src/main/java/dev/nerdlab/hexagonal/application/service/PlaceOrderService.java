package dev.nerdlab.hexagonal.application.service;

import dev.nerdlab.hexagonal.application.port.in.PlaceOrderUseCase;
import dev.nerdlab.hexagonal.domain.model.Order;
import dev.nerdlab.hexagonal.domain.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PlaceOrderService implements PlaceOrderUseCase {

    private final OrderRepository repository;

    @Override
    public UUID placeOrder(Order order) {
        order.applyDiscount(BigDecimal.TEN);
        Order savedOrder = repository.save(order);
        return savedOrder.getId();
    }

    @Override
    public Order findById(String id) {
        UUID uuid = UUID.fromString(id);
        return repository.findById(uuid)
                .orElseThrow(()-> new RuntimeException("Order Not Found"));
    }
}
