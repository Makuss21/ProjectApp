package com.example.projectapp.controller.dto.employee;

import com.example.projectapp.model.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeDtoMapper {

    private EmployeeDtoMapper() {

    }

    public static List<EmployeeDataTransferObject> mapToDto(List<Employee> employees) {
        return employees.stream()
                .map(EmployeeDtoMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }

    public static EmployeeDataTransferObject mapToEmployeeDto(Employee employee) {
        return EmployeeDataTransferObject.builder()
                .employeeId(employee.getEmployeeId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .login(employee.getLogin())
                .password(employee.getPassword())
                .build();
    }


}
