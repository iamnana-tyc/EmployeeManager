package com.iamnana.EmployeeManagerBackend.service;

import com.iamnana.EmployeeManagerBackend.entity.Employee;
import com.iamnana.EmployeeManagerBackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImp  implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    @Override
    public Employee getEmployeeById(Long id) {
        return null;
    }

    @Override
    public String deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
        return "Employee successfully deleted.";
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee empl = employeeRepository.findById(id).get();

        if(Objects.nonNull(employee.getName()) && !"".equalsIgnoreCase(employee.getName())){
            empl.setName(employee.getName());
        }
        if(Objects.nonNull(employee.getEmail()) && !"".equalsIgnoreCase(employee.getEmail())){
            empl.setEmail(employee.getEmail());
        }
        if(Objects.nonNull(employee.getJobTitle()) && !"".equalsIgnoreCase(employee.getJobTitle())){
            empl.setJobTitle(employee.getJobTitle());
        }
        if(Objects.nonNull(employee.getPhone()) && !"".equalsIgnoreCase(employee.getPhone())){
            empl.setPhone(employee.getPhone());
        }
        if(Objects.nonNull(employee.getEmployeeCode()) && !"".equalsIgnoreCase(employee.getEmployeeCode())){
            empl.setEmployeeCode(employee.getEmployeeCode());
        }
        if(Objects.nonNull(employee.getImageUrl()) && !"".equalsIgnoreCase(employee.getImageUrl())){
            empl.setImageUrl(employee.getImageUrl());
        }
         return employeeRepository.save(empl);
    }
}
