package com.damiantomczyszyn.bookstorespring.repository;

import com.damiantomczyszyn.bookstorespring.model.Order;
import com.damiantomczyszyn.bookstorespring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByOrdersWithin(Order order);
}
