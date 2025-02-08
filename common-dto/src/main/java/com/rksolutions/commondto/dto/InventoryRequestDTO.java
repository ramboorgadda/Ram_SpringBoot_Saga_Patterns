package com.rksolutions.commondto.dto;

import jdk.jfr.DataAmount;
import lombok.Data;

import java.util.UUID;

@Data
public class InventoryRequestDTO {

    private Integer userId;
    private Integer productId;
    private UUID orderId;
}
