package dev.nerdlab.hexagonal.adapters.outbound.persistence;

import dev.nerdlab.hexagonal.adapters.outbound.persistence.entity.OrderEntity;
import dev.nerdlab.hexagonal.domain.model.Order;
import dev.nerdlab.hexagonal.domain.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private final JpaOrderRepository repository;
    private final OrderPersistenceMapper mapper;


    @Override
    public Order save(Order order) {
        OrderEntity entity = mapper.toEntity(order);
        OrderEntity savedEntity = repository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Order> findById(UUID uuid) {
        return repository.findById(uuid).map(mapper::toDomain);
    }
}
