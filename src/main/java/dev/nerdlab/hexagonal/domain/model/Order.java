package dev.nerdlab.hexagonal.domain.model;

import dev.nerdlab.hexagonal.domain.enumerator.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class Order {
    private final UUID id;
    private BigDecimal total;
    private OrderStatus status;

    public void applyDiscount(BigDecimal discount){
        if(status == OrderStatus.COMPLETED) {
            throw new IllegalStateException("Cannot Apply discount into a COMPLETED order");
        }
        if (discount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Discount must be positive");
        }

        if (total.subtract(discount).compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalStateException("Total cannot be negative");
        }
        else total = total.subtract(discount);
    }

}
