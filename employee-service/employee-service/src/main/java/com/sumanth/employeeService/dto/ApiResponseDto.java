package com.sumanth.employeeService.dto;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseDto {
    private EmployeeDto employee;
    private DepartmentDto department;
}

