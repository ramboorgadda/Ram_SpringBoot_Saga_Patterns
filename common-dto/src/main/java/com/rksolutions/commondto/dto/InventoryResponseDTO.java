package com.rksolutions.commondto.dto;

import com.rksolutions.commondto.enums.InventoryStatus;
import lombok.Data;

import java.util.UUID;

@Data
public class InventoryResponseDTO {

    private UUID orderId;
    private Integer userId;
    private Integer productId;
    private InventoryStatus inventoryStatus;
}
