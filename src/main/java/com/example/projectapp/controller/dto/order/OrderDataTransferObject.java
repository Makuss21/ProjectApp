package com.example.projectapp.controller.dto.order;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDataTransferObject {
    private Long orderId;
    private String name;
    private String lastName;
    private String status;
    private LocalDate orderDate;
    private Long employeeId;

}
