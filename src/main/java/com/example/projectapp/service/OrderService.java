package com.example.projectapp.service;

import com.example.projectapp.controller.dto.order.OrderDataTransferObject;
import com.example.projectapp.model.Order;
import com.example.projectapp.model.Product;
import com.example.projectapp.repository.OrderRepository;
import com.example.projectapp.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private static final int pageSize = 5;


    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders(int pageNumber, Sort.Direction sortDirection) {
        int pageSize = 10;
        return orderRepository.findAllOrders(PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, "orderId")));
    }
    public Order getSingleOrder(long orderId) {
        return orderRepository.findById(orderId).orElseThrow();
    }
//
//        public List<OrderDataTransferObject> getAllOrdersWithProducts(int pageNumber, Sort.Direction sortDirection) {
//        List<Order> orders = orderRepository.findAllWithProducts();
//        return orders.stream().map(this::convertToDto).collect(Collectors.toList());
//    }

    private OrderDataTransferObject convertToDto(Order order) {

        OrderDataTransferObject orderDTO = new OrderDataTransferObject();
        orderDTO.setOrderId(order.getOrderId());
        orderDTO.setName(order.getName());
        orderDTO.setLastName(order.getLastName());
        orderDTO.setStatus(order.getStatus());
        orderDTO.setOrderDate(order.getOrderDate());
        orderDTO.setEmployeeId(order.getEmployeeId());
        return orderDTO;

    }


    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }
    @Transactional
    public Order editOrder(Order order) {
        Order o1 = orderRepository.findById(order.getOrderId()).orElseThrow();
        o1.setName(order.getName());
        o1.setLastName(order.getLastName());
        o1.setStatus(order.getStatus());
        o1.setEmployeeId(order.getEmployeeId());
        return orderRepository.save(o1);
    }
    public void deleteOrder(long orderId) {
        orderRepository.deleteById(orderId);
    }

}
