package com.rksolutions.orderservice.repository;

import com.rksolutions.orderservice.entity.PurchaseOrder;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface PurchaseOrderRepository extends ReactiveCrudRepository<PurchaseOrder, UUID> {
}
