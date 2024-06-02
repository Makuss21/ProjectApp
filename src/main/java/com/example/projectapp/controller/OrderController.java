package com.example.projectapp.controller;


import com.example.projectapp.controller.dto.order.OrderDataTransferObject;
import com.example.projectapp.controller.dto.order.OrderDtoMapper;
import com.example.projectapp.model.Order;
import com.example.projectapp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {
    @Autowired
    private final OrderService orderService;

    @GetMapping("/order")
    public List<OrderDataTransferObject> getAllOrders(@RequestParam(required = false) Integer page, Sort.Direction sort) {
        int pageNumber = page != null && page >= 0? page : 0;
        Sort.Direction sortDirection = sort != null? sort : Sort.Direction.ASC;
        return OrderDtoMapper.mapToDto(orderService.getAllOrders(pageNumber,sortDirection));
    }
    @GetMapping("/order/{id}")
    public Order getSingleOrder(@PathVariable Integer id) {
        return orderService.getSingleOrder(id);
    }
//    @GetMapping("/order/products")
//    public List<OrderDataTransferObject> getOrdersWithProducts(@RequestParam(required = false) Integer page, Sort.Direction sort){
//        int pageNumber = page != null && page >= 0? page : 0;
//        Sort.Direction sortDirection = sort != null? sort : Sort.Direction.ASC;
//        return orderService.getAllOrdersWithProducts(pageNumber,sortDirection);
//    }
    @PostMapping("/order")
    public Order addOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
    }
    @PutMapping("/order")
    public Order editOrder(@RequestBody Order order) {
        return orderService.editOrder(order);
    }
    @DeleteMapping("/order")
    public void deleteOrder(@RequestParam long id) {
        orderService.deleteOrder(id);
    }
}

