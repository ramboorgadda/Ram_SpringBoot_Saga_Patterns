package com.rksolutions.inventoryservice.controller;

import com.rksolutions.commondto.dto.InventoryRequestDTO;
import com.rksolutions.commondto.dto.InventoryResponseDTO;
import com.rksolutions.inventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;
    @PostMapping("/add")
    public void add(@RequestBody final InventoryRequestDTO requestDTO){
        inventoryService.addInventory(requestDTO);
    }
    @PostMapping("/deduct")
    public InventoryResponseDTO deduct(@RequestBody final InventoryRequestDTO requestDTO){
       InventoryResponseDTO responseDTO =inventoryService.deductInventory(requestDTO);
       return responseDTO;
    }
}
