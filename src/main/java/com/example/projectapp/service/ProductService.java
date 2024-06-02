package com.example.projectapp.service;


import com.example.projectapp.model.Product;
import com.example.projectapp.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    private static final int pageSize = 5;

    public List<Product> getAllProducts(int pageNumber, Sort.Direction sortDirection) {
        return productRepository.findAllProducts(PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection,"PCODE")));
    }
    public Product getSingleProduct(long productCode) {
        return productRepository.findById(productCode).orElseThrow();
    }
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
    @Transactional
    public Product editProduct(Product product) {
        Product p1 = productRepository.findById(product.getPCODE()).orElseThrow();
        p1.setNAME(product.getNAME());
        p1.setPRICE(product.getPRICE());
        return productRepository.save(p1);
    }
    public void deleteProduct(long productCode) {
        productRepository.deleteById(productCode);
    }


}
