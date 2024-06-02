package com.example.projectapp.repository;

import com.example.projectapp.model.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long>, JpaRepository<Order, Long> {

    @Query("SELECT O FROM Order O")
    List<Order> findAllOrders(Pageable pageable);

    List<Order> findAllByEmployeeIdIn(List<Long> ids);

//    @Query("select distinct o from Order o join fetch o.productOrders po join fetch po.product")
//    List<Order> findAllWithProducts();



}
