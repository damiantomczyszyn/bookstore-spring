package com.damiantomczyszyn.bookstorespring.repository;

import com.damiantomczyszyn.bookstorespring.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
