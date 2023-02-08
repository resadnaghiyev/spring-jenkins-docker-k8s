package com.rashad.springcrudkubernetes.controller;

import com.rashad.springcrudkubernetes.entity.Order;
import com.rashad.springcrudkubernetes.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public Order addOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
    }

    @GetMapping
    public List<Order> getOrders() {
        return orderService.getOrders();
    }

    @GetMapping("/{id}")
    public Order getOneOrder(@PathVariable("id") Long orderId) {
        return orderService.getOneOrder(orderId);
    }

}
