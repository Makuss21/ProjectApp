package com.example.projectapp.service;

import com.example.projectapp.model.Employee;
import com.example.projectapp.model.Order;
import com.example.projectapp.repository.EmployeeRepository;
import com.example.projectapp.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private OrderRepository orderRepository;
    private static final int pageSize = 5;

    public List<Employee> getAllEmployees(int pageNumber, Sort.Direction sort) {
        return employeeRepository.findAllEmployees(PageRequest.of(pageNumber, pageSize,Sort.by(sort,"employeeId")));
    }

    public Employee getSingleEmployee(long employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow();
    }

    public List<Employee> getEmployeesWithOrders(int pageNumber, Sort.Direction sort) {
        List<Employee> allEmployees = employeeRepository.findAllEmployees(PageRequest.of(pageNumber, pageSize,Sort.by(sort,"employeeId")));

        List<Long> ids = allEmployees.stream()
                .map(Employee::getEmployeeId)
                .toList();

        List<Order> orders = orderRepository.findAllByEmployeeIdIn(ids);
        allEmployees.forEach(employee -> employee.setOrders(extractOrders(orders, employee.getEmployeeId())));
        return allEmployees;

    }

    private List<Order> extractOrders(List<Order> orders, long employeeId) {
        return orders.stream()
                .filter(order -> order.getEmployeeId() == employeeId)
                .toList();
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    @Transactional
    public Employee editEmployee(Employee employee) {
        Employee e1 = employeeRepository.findById(employee.getEmployeeId()).orElseThrow();
        e1.setEmployeeId(employee.getEmployeeId());
        e1.setFirstName(employee.getFirstName());
        e1.setLastName(employee.getLastName());
        e1.setLogin(employee.getLogin());
        e1.setPassword(employee.getPassword());
        return employeeRepository.save(e1);
    }
    public void deleteEmployee(long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

}
