package com.example.projectapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PRODUCTSORDERS")
public class ProductOrder {

    @Id
    @ManyToOne
    @JoinColumn(name = "ORDER_ID",nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "PCODE",nullable = false)
    private Product product;

    @Column(name = "QUANTITY")
    private Integer quantity;


}
