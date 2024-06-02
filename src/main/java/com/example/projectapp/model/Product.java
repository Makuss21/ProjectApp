package com.example.projectapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "PRODUCTS")
public class Product {
    @Id
    @Column(name = "PCODE")
    private Long PCODE;

    @Column(name = "NAME")
    private String NAME;

    @Column(name = "PRICE")
    private BigDecimal PRICE;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProductOrder> productOrders;
//    @OneToMany
//    @JoinColumn(name = "PCODE",updatable = false,insertable = false)
//    private List<ProductOrder> productOrders;


}
