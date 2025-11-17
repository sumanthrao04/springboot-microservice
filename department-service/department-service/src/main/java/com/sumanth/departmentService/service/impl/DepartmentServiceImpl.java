package com.sumanth.departmentService.service.impl;

import com.sumanth.departmentService.dto.DepartmentDto;
import com.sumanth.departmentService.entity.Department;
import com.sumanth.departmentService.repository.DepartmentRepository;
import com.sumanth.departmentService.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
     private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        //covert department dto into department jpa entity
        Department department = new Department(
          departmentDto.getId(),
          departmentDto.getDepartmentName(),
          departmentDto.getDepartmentDescription(),
          departmentDto.getDepartmentCode()
        );

      Department savedDepartment=departmentRepository.save(department);

      //convert saved department to dto as a response to client
        return new DepartmentDto(
                savedDepartment.getId(),
                savedDepartment.getDepartmentName(),
                savedDepartment.getDepartmentDescription(),
                savedDepartment.getDepartmentCode()

        );
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);

        //convert saved department to dto as a response to client
        return new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );
    }
}
