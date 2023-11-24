package com.iamnana.EmployeeManagerBackend.service;

import com.iamnana.EmployeeManagerBackend.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    String deleteEmployeeById(Long id);

    Employee updateEmployee(Long id, Employee employee);
}
