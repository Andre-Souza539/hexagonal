package dev.nerdlab.hexagonal.adapters.outbound.persistence;

import dev.nerdlab.hexagonal.adapters.outbound.persistence.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JpaOrderRepository extends JpaRepository<OrderEntity, UUID> {
    @Override
    Optional<OrderEntity> findById(UUID uuid);
}
