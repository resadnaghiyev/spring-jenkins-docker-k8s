package com.rashad.springcrudkubernetes.repository;

import com.rashad.springcrudkubernetes.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
