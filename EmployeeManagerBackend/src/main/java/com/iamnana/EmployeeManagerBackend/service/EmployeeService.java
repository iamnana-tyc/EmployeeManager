package com.iamnana.EmployeeManagerBackend.service;

import com.iamnana.EmployeeManagerBackend.payload.EmployeeDTO;
import com.iamnana.EmployeeManagerBackend.payload.EmployeeResponse;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    EmployeeResponse findAllEmployees(Integer pageNumber, Integer pageSize);

    EmployeeDTO updateEmployee(EmployeeDTO employeeDTO, Long employeeId);

    EmployeeDTO deleteEmployee(Long employeeId);
}
