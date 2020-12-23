package com.dsr.jschool.service;

import com.dsr.jschool.data.dto.OrderDto;
import com.dsr.jschool.data.entity.Order;
import com.dsr.jschool.data.entity.SparePart;
import com.dsr.jschool.data.repository.OrderRepository;
import com.dsr.jschool.exeption.WrongDataException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderService {

    private final UserService userService;
    private final SparePartService sparePartService;
    private final OrderRepository orderRepository;

    public OrderService(UserService userService, SparePartService sparePartService, OrderRepository orderRepository) {
        this.userService = userService;
        this.sparePartService = sparePartService;
        this.orderRepository = orderRepository;
    }

    public Order buySparePart(Long sparePartId, String login) {
        SparePart sparePart = sparePartService.getSparePart(sparePartId);
        if(sparePart.getCount() - 1 >= 0){
            sparePart.setCount(sparePart.getCount() - 1);
            Order order = new Order();
            order.setCustomer(userService.getUser(userService.findByLogin(login).getId()));
            order.setSparePart(sparePart);
            order.setDate(new Date());
            sparePartService.createOrUpdateSparePart(sparePart, sparePart.getStoreBranch().getId());
            return orderRepository.save(order);
        }
        throw new WrongDataException();
    }
}
