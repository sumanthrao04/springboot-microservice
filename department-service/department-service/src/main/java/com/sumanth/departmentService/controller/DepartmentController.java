package com.sumanth.departmentService.controller;

import com.sumanth.departmentService.dto.DepartmentDto;
import com.sumanth.departmentService.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/department")
@AllArgsConstructor
public class DepartmentController {
    private DepartmentService departmentService;

    @PostMapping("/save")
    public ResponseEntity<DepartmentDto>  savedUser( @RequestBody DepartmentDto departmentDto){
       DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);

    }

    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto>  getDepartmentById(@PathVariable(name = "department-code") String departmentCode){
        DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(departmentDto,HttpStatus.OK);
    }

}
