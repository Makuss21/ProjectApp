package com.example.projectapp.controller;

import com.example.projectapp.controller.dto.employee.EmployeeDataTransferObject;
import com.example.projectapp.controller.dto.employee.EmployeeDtoMapper;
import com.example.projectapp.model.Employee;
import com.example.projectapp.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/employee")
    public List<EmployeeDataTransferObject> getAllEmployees(@RequestParam(required = false) Integer page, Sort.Direction sort) {
        int pageNumber = page != null && page >= 0? page : 0;
        Sort.Direction sortDirection = sort != null? sort : Sort.Direction.ASC;
        return EmployeeDtoMapper.mapToDto(employeeService.getAllEmployees(pageNumber,sortDirection));
    }
    @GetMapping("employee/{id}")
    public Employee getSingleEmployee(@PathVariable int id) {
        return employeeService.getSingleEmployee(id);
    }
    @GetMapping("employee/orders")
    public List<Employee> getEmployeesWithOrders(@RequestParam(required = false) Integer page, Sort.Direction sort) {
        int pageNumber = page != null && page >= 0? page : 0;
        Sort.Direction sortDirection = sort != null? sort : Sort.Direction.ASC;
        return employeeService.getEmployeesWithOrders(pageNumber,sortDirection);
    }
    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }
    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.editEmployee(employee);
    }
    @DeleteMapping("/employee")
    public void deleteEmployee(@RequestParam long id) {
        employeeService.deleteEmployee(id);
    }
}

