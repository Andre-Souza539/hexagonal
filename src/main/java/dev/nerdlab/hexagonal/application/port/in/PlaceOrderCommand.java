package dev.nerdlab.hexagonal.application.port.in;

import java.math.BigDecimal;

public record PlaceOrderCommand(BigDecimal total) {

}
