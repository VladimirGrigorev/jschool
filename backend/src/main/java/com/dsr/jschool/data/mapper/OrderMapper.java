package com.dsr.jschool.data.mapper;

import com.dsr.jschool.data.dto.OrderDto;
import com.dsr.jschool.data.entity.Order;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper{

    OrderDto orderToOrderDto(Order order);
    List<OrderDto> orderToOrderDto(List<Order> order);
}
