package com.sumanth.employeeService.service;

import com.sumanth.employeeService.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    EmployeeDto EmployeeByID(Long id);
}
