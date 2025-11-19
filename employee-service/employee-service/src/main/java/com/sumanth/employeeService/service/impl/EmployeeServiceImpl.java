package com.sumanth.employeeService.service.impl;

import com.sumanth.employeeService.dto.ApiResponseDto;
import com.sumanth.employeeService.dto.DepartmentDto;
import com.sumanth.employeeService.dto.EmployeeDto;
import com.sumanth.employeeService.entity.Employee;
import com.sumanth.employeeService.repository.EmployeeRepository;
import com.sumanth.employeeService.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl  implements EmployeeService {

    private RestTemplate restTemplate;
  private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {


        Employee saveToDb = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );

       Employee savedEmployee=  employeeRepository.save(saveToDb);



        return new EmployeeDto(
                savedEmployee.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );
    }

    @Override
    public ApiResponseDto EmployeeByID(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + employeeId));

       ResponseEntity<DepartmentDto> response= restTemplate.getForEntity("http://localhost:8080/api/department/"+employee.getDepartmentCode(), DepartmentDto.class);
        DepartmentDto departmentDto =response.getBody();
        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );

        ApiResponseDto responseEntity = new ApiResponseDto();
        responseEntity.setEmployee(employeeDto);
        responseEntity.setDepartment(departmentDto);


        return responseEntity;
    }
}
