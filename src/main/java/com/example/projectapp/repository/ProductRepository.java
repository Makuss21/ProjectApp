package com.example.projectapp.repository;

import com.example.projectapp.model.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

    @Query("SELECT P FROM Product P")
    List<Product> findAllProducts(Pageable pageable);

//    @Query("SELECT p FROM Product p WHERE p.PCODE IN :pcodes")
//    List<Product> findAllByPcodes(@Param("pcodes") List<Long> pcodes);

}
