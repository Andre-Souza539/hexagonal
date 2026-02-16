package dev.nerdlab.hexagonal.adapters.inbound.dto;

import dev.nerdlab.hexagonal.domain.enumerator.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class OrderDTO {
    private UUID id;
    private BigDecimal total;
    private OrderStatus status;
}
