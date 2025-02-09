package com.rksolutions.inventoryservice.service;

import com.rksolutions.commondto.dto.InventoryRequestDTO;
import com.rksolutions.commondto.dto.InventoryResponseDTO;
import com.rksolutions.commondto.enums.InventoryStatus;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

@Service
public class InventoryService {
    HashMap<Integer,Integer> productInventoryMap;
    @PostConstruct
    public void init(){
      this.productInventoryMap = new HashMap<>();
      productInventoryMap.put(1,5);
      productInventoryMap.put(2,5);
      productInventoryMap.put(3,5);
    }

    public InventoryResponseDTO deductInventory(InventoryRequestDTO requestDTO){
        Integer quantity = productInventoryMap.getOrDefault(requestDTO.getUserId(),0);
               InventoryResponseDTO inventoryResponseDTO = new InventoryResponseDTO();
               inventoryResponseDTO.setUserId(requestDTO.getUserId());
               inventoryResponseDTO.setOrderId(requestDTO.getOrderId());
               inventoryResponseDTO.setProductId(requestDTO.getProductId());
               inventoryResponseDTO.setInventoryStatus(InventoryStatus.UNAVAILABLE);
               if(quantity >0){
                   inventoryResponseDTO.setInventoryStatus(InventoryStatus.AVAILABLE);
                   this.productInventoryMap.put(requestDTO.getUserId(),quantity-1);
               }
           return inventoryResponseDTO;
    }
    public void addInventory(InventoryRequestDTO requestDTO){
        productInventoryMap.computeIfPresent(requestDTO.getUserId(), (k, v) -> v+1);
    }
}
