package dev.nerdlab.hexagonal.adapters.inbound.web;

import dev.nerdlab.hexagonal.adapters.inbound.dto.OrderDTO;
import dev.nerdlab.hexagonal.domain.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderWebMapper {
    public Order dtoToDomain(OrderDTO dto){
        return new Order(dto.getId(), dto.getTotal(), dto.getStatus());
    }

    public OrderDTO toDTO(Order order){
        return new OrderDTO(order.getId(), order.getTotal(), order.getStatus());
    }

}
