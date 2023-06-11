package com.damiantomczyszyn.bookstorespring.controller;



import com.damiantomczyszyn.bookstorespring.ItemOperation;
import com.damiantomczyszyn.bookstorespring.model.Item;
import com.damiantomczyszyn.bookstorespring.model.Order;
import com.damiantomczyszyn.bookstorespring.repository.ItemRepository;
import com.damiantomczyszyn.bookstorespring.repository.OrderRepository;
import com.damiantomczyszyn.bookstorespring.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final ItemRepository itemRepository;
    private final OrderRepository orderRepository;
    private final CartService cartService;

    @Autowired
    public AdminController(ItemRepository itemRepository, OrderRepository orderRepository, CartService cartService) {
        this.itemRepository = itemRepository;
        this.orderRepository = orderRepository;
        this.cartService = cartService;
    }

    @GetMapping
    private String adminPage() {
        return "adminview/addItem";
    }

    @GetMapping("/delete")
    private String adminPage2(Model model) {
        model.addAttribute("items", cartService.getAllItems());
        return "adminview/deleteItem";
    }

    @GetMapping("/delete/{itemId}")
    public String DeleteItemFromCart(@PathVariable("itemId") Long itemId, Model model) {
        cartService.removeItem(itemId);
        model.addAttribute("items", cartService.getAllItems());
        return "adminview/deleteItem";
    }

    @PostMapping
    private String addItem(Item item) {
        itemRepository.save(item);
        return "redirect:/";
    }

    @GetMapping("/showorders")
    @ResponseBody
    public List<Order> showOrders() {
        return orderRepository.findAll();
    }
}