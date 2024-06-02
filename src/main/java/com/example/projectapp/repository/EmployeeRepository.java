package com.example.projectapp.repository;

import com.example.projectapp.model.Employee;
import com.example.projectapp.model.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("select E from Employee E")
    List<Employee> findAllEmployees(Pageable pageable);


}
