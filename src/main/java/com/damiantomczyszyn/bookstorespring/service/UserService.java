package com.damiantomczyszyn.bookstorespring.service;

import com.damiantomczyszyn.bookstorespring.model.Order;
import com.damiantomczyszyn.bookstorespring.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addOrder(Order order, String email) {
        var user = userRepository.findByEmail(email);
        if (!user.isPresent()){
            throw new EntityNotFoundException();
        }
        user.get().addOrder(order);

    }


    public void removeOrder(Long orderId, Long userId) {

    return;
    }
}
