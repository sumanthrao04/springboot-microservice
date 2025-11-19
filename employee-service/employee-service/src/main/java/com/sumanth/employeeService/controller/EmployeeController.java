package com.sumanth.employeeService.controller;

import com.sumanth.employeeService.dto.ApiResponseDto;
import com.sumanth.employeeService.dto.EmployeeDto;
import com.sumanth.employeeService.entity.Employee;
import com.sumanth.employeeService.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/employee")


public class EmployeeController {
    private EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
       EmployeeDto saveEmployee= employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponseDto> getEmployee(@PathVariable("id") Long employeeId){
        ApiResponseDto employeeDto = employeeService.EmployeeByID(employeeId);
        return new ResponseEntity<>(employeeDto,HttpStatus.OK);
                
                
    }

}
