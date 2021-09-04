package com.folksdev.bookstore.controller;

import com.folksdev.bookstore.dto.BookOrderRequest;
import com.folksdev.bookstore.model.Order;
import com.folksdev.bookstore.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/bookstore")
public class BookStoreController {
    private final OrderService orderService;

    public BookStoreController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<String> HelloJava() {
        return ResponseEntity.ok("Hello Java");
    }

    @PostMapping
    public  ResponseEntity<Order> putAnOrder(@RequestBody BookOrderRequest bookOrderRequest){
        Order order = orderService.putAndOrder(bookOrderRequest.getBookIdList(),bookOrderRequest.getUserName());

        return ResponseEntity.ok(order);
    }

}
