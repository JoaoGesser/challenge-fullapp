package com.challenge.api.repository.order;

import com.challenge.api.model.entity.order.ClientProductOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientProductOrderRepository extends JpaRepository<ClientProductOrderEntity, Long> {
}