package com.example.projectapp.controller.dto.product;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class ProductDataTransferObject {
    private long PCODE;
    private String NAME;
    private BigDecimal PRICE;

}
