package com.dsr.jschool.data.repository;

import com.dsr.jschool.data.entity.Order;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {

}
