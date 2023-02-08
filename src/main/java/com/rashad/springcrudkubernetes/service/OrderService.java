package com.rashad.springcrudkubernetes.service;

import com.rashad.springcrudkubernetes.entity.Order;
import com.rashad.springcrudkubernetes.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Order getOneOrder(Long orderId) {
        return orderRepository.findById(orderId).get();
    }
}
