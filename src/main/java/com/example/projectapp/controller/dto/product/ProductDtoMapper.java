package com.example.projectapp.controller.dto.product;

import com.example.projectapp.model.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ProductDtoMapper {
    private ProductDtoMapper() {

    }

    public static List<ProductDataTransferObject> mapToDto(List<Product> products) {
        return products.stream()
                .map(ProductDtoMapper :: maptoProductDto)
                .collect(Collectors.toList());
    }


    public static ProductDataTransferObject maptoProductDto(Product product) {
        return ProductDataTransferObject.builder()
                .PCODE(product.getPCODE())
                .NAME(product.getNAME())
                .PRICE(product.getPRICE())
                .build();

    }
}
