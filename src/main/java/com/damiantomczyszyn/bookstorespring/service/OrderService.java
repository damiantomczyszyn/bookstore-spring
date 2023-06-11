package com.damiantomczyszyn.bookstorespring.service;

import com.damiantomczyszyn.bookstorespring.dto.OrderDto;
import com.damiantomczyszyn.bookstorespring.mapper.OrderMapper;
import com.damiantomczyszyn.bookstorespring.Cart;
import com.damiantomczyszyn.bookstorespring.model.Order;
import com.damiantomczyszyn.bookstorespring.repository.OrderItemRepository;
import com.damiantomczyszyn.bookstorespring.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderService {

    private final Cart cart;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final UserService userService;

    @Autowired
    public OrderService(Cart cart, OrderRepository orderRepository, OrderItemRepository orderItemRepository, UserService userService) {
        this.cart = cart;
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.userService = userService;
    }

    public void saveOrder(OrderDto orderDto, String name) {
        Order order = OrderMapper.mapToOrder(orderDto);
        orderRepository.save(order);
        userService.addOrder(order, name);

        orderItemRepository.saveAll(OrderMapper.mapToOrderItemList(cart, order));
        cart.cleanCart();
    }

    public void realizeById(Long orderId) {
       var order = orderRepository.findById(orderId);
        if (!order.isPresent()){
            return;
        }
        order.get().setRealized(true);
        orderRepository.save(order.get());
        userService.removeOrder(order.get());
    }
}
