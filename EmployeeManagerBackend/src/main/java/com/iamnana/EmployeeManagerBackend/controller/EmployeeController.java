package com.iamnana.EmployeeManagerBackend.controller;

import com.iamnana.EmployeeManagerBackend.entity.Employee;
import com.iamnana.EmployeeManagerBackend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }
    @GetMapping("/all")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id){
        return employeeService.getEmployeeById(id);
    }
    @DeleteMapping("/employee/{id}")
    public String deleteEmployeeById(@PathVariable("id") Long id){
        return employeeService.deleteEmployeeById(id);
    }
    @PutMapping("update/{id}")
    public Employee updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee){
        return employeeService.updateEmployee(id, employee);

    }
}
