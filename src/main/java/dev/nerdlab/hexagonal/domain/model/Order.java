package dev.nerdlab.hexagonal.domain.model;

import dev.nerdlab.hexagonal.domain.enumerator.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class Order {
    private UUID id;
    private BigDecimal total;
    private OrderStatus status;


    public void applyDiscount(BigDecimal discount){
        if(status == OrderStatus.COMPLETED) {
            throw new IllegalStateException("Cannot Apply discount into a COMPLETED order");
        }
        else total = total.subtract(discount);
    }

}
