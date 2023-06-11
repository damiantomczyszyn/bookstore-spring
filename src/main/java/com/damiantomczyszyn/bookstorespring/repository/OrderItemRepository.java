package com.damiantomczyszyn.bookstorespring.repository;

import com.damiantomczyszyn.bookstorespring.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
