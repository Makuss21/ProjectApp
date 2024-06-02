package com.example.projectapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ORDERS")
public class Order {
    @Id
    private long orderId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "ORDER_DATE")
    private LocalDate orderDate;
    @Column(name = "EMPLOYEE_ID")
    private long employeeId;

//    @OneToMany
//    @JoinColumn(name = "ORDER_ID",updatable = false,insertable = false)
//    private List<ProductOrder> productOrders;



    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProductOrder> productOrders;


}
