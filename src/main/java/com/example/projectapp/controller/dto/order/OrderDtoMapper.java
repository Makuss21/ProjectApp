package com.example.projectapp.controller.dto.order;

import com.example.projectapp.model.Order;

import java.util.List;
import java.util.stream.Collectors;

public class OrderDtoMapper {

    private OrderDtoMapper() {

    }

    public static List<OrderDataTransferObject> mapToDto(List<Order> orders) {
        return orders.stream()
                .map(OrderDtoMapper::maptoOrderDto)
                .collect(Collectors.toList());
    }

    public static OrderDataTransferObject maptoOrderDto(Order order) {
        return OrderDataTransferObject.builder()
                .orderId(order.getOrderId())
                .name(order.getName())
                .lastName(order.getLastName())
                .status(order.getStatus())
                .orderDate(order.getOrderDate())
                .employeeId(order.getEmployeeId())
                .build();

    }
}
