package com.damiantomczyszyn.bookstorespring.controller;



import com.damiantomczyszyn.bookstorespring.ItemOperation;
import com.damiantomczyszyn.bookstorespring.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    private final CartService cartService;

    @Autowired
    public HomeController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("items", cartService.getAllItems());
        return "home";
    }


    @GetMapping("/add/{itemId}")
    public String addItemToCart(@PathVariable("itemId") Long itemId, Model model) {
        cartService.itemOperation(itemId, ItemOperation.INCREASE);
        model.addAttribute("items", cartService.getAllItems());
        return "home";
    }
}
