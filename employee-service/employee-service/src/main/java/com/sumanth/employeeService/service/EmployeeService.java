package com.sumanth.employeeService.service;

import com.sumanth.employeeService.dto.ApiResponseDto;
import com.sumanth.employeeService.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    ApiResponseDto EmployeeByID(Long id);
}
