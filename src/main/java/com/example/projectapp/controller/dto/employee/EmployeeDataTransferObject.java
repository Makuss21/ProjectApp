package com.example.projectapp.controller.dto.employee;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EmployeeDataTransferObject {
    private long employeeId;
    private String firstName;
    private String lastName;
    private String login;
    private String password;

}
