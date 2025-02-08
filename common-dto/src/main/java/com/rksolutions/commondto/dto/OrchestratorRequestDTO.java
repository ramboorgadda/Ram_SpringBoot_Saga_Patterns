package com.rksolutions.commondto.dto;

import lombok.Data;

import java.util.UUID;
@Data

public class OrchestratorRequestDTO {
    private Integer userId;
    private Integer productId;
    private UUID orderId;
    private Double amount;

}
