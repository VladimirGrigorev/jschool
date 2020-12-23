package com.dsr.jschool.controller;

import com.dsr.jschool.data.dto.OrderDto;
import com.dsr.jschool.data.mapper.OrderMapper;
import com.dsr.jschool.service.OrderService;
import org.mapstruct.factory.Mappers;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper mapper = Mappers.getMapper(OrderMapper.class);

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(path = "/buy")
    public OrderDto buySparePart(@RequestBody Long sparePartId, Authentication authentication) {
        String currentPrincipalName = authentication.getName();
        var order = orderService.buySparePart(sparePartId, currentPrincipalName);
        return mapper.orderToOrderDto(order);
    }
}
