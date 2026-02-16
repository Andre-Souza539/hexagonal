package dev.nerdlab.hexagonal.domain.model;

import dev.nerdlab.hexagonal.domain.enumerator.OrderStatus;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void shouldApplyDiscount(){
        Order order = new Order(
                UUID.randomUUID(),
                new BigDecimal(100),
                OrderStatus.NEW
        );

        order.applyDiscount(new BigDecimal(10));

        assertEquals(new BigDecimal(90), order.getTotal());

    }

    @Test
    void shouldNotApplyDiscount(){
        Order order = new Order(
                UUID.randomUUID(),
                new BigDecimal(100),
                OrderStatus.COMPLETED
        );

        assertThrows(IllegalStateException.class,()-> order.applyDiscount(BigDecimal.TEN));

    }

}