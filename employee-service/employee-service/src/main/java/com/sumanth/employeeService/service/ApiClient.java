package com.sumanth.employeeService.service;

import com.sumanth.employeeService.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8080",value = "DEPARTMENT-SERVICE")
public interface ApiClient {
    @GetMapping("api/department/{departmentCode}")
    DepartmentDto getDepartmentById(@PathVariable("departmentCode") String departmentCode);

}
