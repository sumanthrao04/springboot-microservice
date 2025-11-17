package com.sumanth.employeeService.service.impl;

import com.sumanth.employeeService.dto.EmployeeDto;
import com.sumanth.employeeService.entity.Employee;
import com.sumanth.employeeService.repository.EmployeeRepository;
import com.sumanth.employeeService.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl  implements EmployeeService {

  private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee saveToDb = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );

       Employee savedEmployee=  employeeRepository.save(saveToDb);



        return new EmployeeDto(
                savedEmployee.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }

    @Override
    public EmployeeDto EmployeeByID(Long id) {
        Employee employee =employeeRepository.findById(id).get();

        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }
}
