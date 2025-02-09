package com.rksolutions.orderservice;

import com.rksolutions.commondto.dto.OrchestratorResponseDTO;
import com.rksolutions.orderservice.repository.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class OrderEventUpdateService {

    @Autowired
    private PurchaseOrderRepository repository;

    public Mono<Void> updateOrder(final OrchestratorResponseDTO responseDTO){
        return this.repository.findById(responseDTO.getOrderId())
                .doOnNext(p -> p.setOrderStatus(responseDTO.getStatus()))
                .flatMap(purchaseOrder -> repository.save(purchaseOrder)).then();
    }
}
