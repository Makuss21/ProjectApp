package com.example.projectapp.controller;


import com.example.projectapp.controller.dto.product.ProductDataTransferObject;
import com.example.projectapp.controller.dto.product.ProductDtoMapper;
import com.example.projectapp.model.Product;
import com.example.projectapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/product")
    public List<ProductDataTransferObject> getAllProducts(@RequestParam(required = false) Integer page, Sort.Direction sortDirection) {
        int pageNumber = page != null && page > 0 ? page : 0;
        Sort.Direction direction = sortDirection != null ? sortDirection : Sort.Direction.ASC;
        return ProductDtoMapper.mapToDto(productService.getAllProducts(pageNumber, direction));
    }
    @GetMapping("/product/{id}")
    public Product getSingleProduct(@PathVariable int id) {
        return productService.getSingleProduct(id);
    }
    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }
    @PutMapping("/product")
    public Product updateProduct(@RequestBody Product product) {
        return productService.editProduct(product);
    }
    @DeleteMapping("/product")
    public void deleteProduct(@RequestParam long pcode) {
        productService.deleteProduct(pcode);
    }


}
