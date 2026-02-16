package dev.nerdlab.hexagonal.adapters.inbound;

import dev.nerdlab.hexagonal.adapters.inbound.dto.OrderDTO;
import dev.nerdlab.hexagonal.adapters.inbound.web.OrderWebMapper;
import dev.nerdlab.hexagonal.application.port.in.PlaceOrderUseCase;
import dev.nerdlab.hexagonal.domain.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final PlaceOrderUseCase useCase;
    private final OrderWebMapper mapper;

    @PostMapping()
    public ResponseEntity<String> placeOrder(@RequestBody OrderDTO dto){
        Order order = mapper.dtoToDomain(dto);
        UUID orderId = useCase.placeOrder(order);
        return ResponseEntity.ok(orderId.toString());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> findById(@PathVariable String id){
        Order order = useCase.findById(id);
        OrderDTO response = mapper.toDTO(order);
        return ResponseEntity.ok(response);
    }

}
