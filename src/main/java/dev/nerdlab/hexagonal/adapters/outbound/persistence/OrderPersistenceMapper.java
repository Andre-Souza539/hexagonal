package dev.nerdlab.hexagonal.adapters.outbound.persistence;

import dev.nerdlab.hexagonal.adapters.outbound.persistence.entity.OrderEntity;
import dev.nerdlab.hexagonal.domain.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderPersistenceMapper {
    public Order toDomain(OrderEntity entity) {
        return new Order(
                entity.getId(),
                entity.getTotal(),
                entity.getStatus()
        );
    }

    public OrderEntity toEntity(Order order) {
        return new OrderEntity(
                order.getId(),
                order.getTotal(),
                order.getStatus()
        );
    }
}
