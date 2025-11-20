package com.sumanth.employeeService.service;

import com.sumanth.employeeService.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name ="department-service" )
public interface ApiClient {
    @GetMapping("departments/{departmentCode}")
    DepartmentDto getDepartmentById(@PathVariable("departmentCode") String departmentCode);

}
