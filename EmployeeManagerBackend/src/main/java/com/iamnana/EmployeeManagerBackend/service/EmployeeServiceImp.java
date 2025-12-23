package com.iamnana.EmployeeManagerBackend.service;

import com.iamnana.EmployeeManagerBackend.exception.ResourcesNotFoundException;
import com.iamnana.EmployeeManagerBackend.model.Employee;
import com.iamnana.EmployeeManagerBackend.exception.APIException;
import com.iamnana.EmployeeManagerBackend.payload.EmployeeDTO;
import com.iamnana.EmployeeManagerBackend.payload.EmployeeResponse;
import com.iamnana.EmployeeManagerBackend.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        employee.setImageUrl("default.jpg");
        Employee saveEmployee = employeeRepository.save(employee);

        return modelMapper.map(saveEmployee, EmployeeDTO.class);
    }

    @Override
    public EmployeeResponse findAllEmployees(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Employee> employeePage = employeeRepository.findAll(pageable);
        List<Employee> employees = employeePage.getContent();

        List<EmployeeDTO> employeeDTOs = employees.stream()
                .map(employer-> modelMapper.map(employer, EmployeeDTO.class))
                .toList();

        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setContent(employeeDTOs);
        employeeResponse.setPageNumber(employeePage.getNumber());
        employeeResponse.setPageSize(employeePage.getSize());
        employeeResponse.setTotalPages(employeePage.getTotalPages());
        employeeResponse.setTotalElements(employeePage.getTotalElements());
        employeeResponse.setLastPage(employeePage.isLast());

        return employeeResponse;
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO, Long employeeId) {
        Employee existingEmployee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourcesNotFoundException("Employee", "employeeId", + employeeId));

        existingEmployee.setName(employeeDTO.getName());
        existingEmployee.setEmail(employeeDTO.getEmail());
        existingEmployee.setJobTitle(employeeDTO.getJobTitle());
        existingEmployee.setPhone(employeeDTO.getPhone());
        existingEmployee.setEmployeeCode(employeeDTO.getEmployeeCode());
        existingEmployee.setImageUrl("default.jpg");

        Employee updateEmployees = employeeRepository.save(existingEmployee);


        return modelMapper.map(updateEmployees, EmployeeDTO.class);
    }

    @Override
    public EmployeeDTO deleteEmployee(Long employeeId) {
        Employee existingEmployee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourcesNotFoundException("Employee", "employeeId", + employeeId));

        if (existingEmployee != null) {
            employeeRepository.delete(existingEmployee);
        } else
            throw new APIException("Employee was not found.");

        return modelMapper.map(existingEmployee, EmployeeDTO.class);
    }
}
