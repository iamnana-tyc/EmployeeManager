package com.iamnana.EmployeeManagerBackend.controller;

import com.iamnana.EmployeeManagerBackend.config.AppConstant;
import com.iamnana.EmployeeManagerBackend.payload.EmployeeDTO;
import com.iamnana.EmployeeManagerBackend.payload.EmployeeResponse;
import com.iamnana.EmployeeManagerBackend.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees")
    public ResponseEntity<EmployeeDTO> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO employee = employeeService.createEmployee(employeeDTO);

        return new  ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @GetMapping("/employees")
    public ResponseEntity<EmployeeResponse> getAllEmployees(
            @RequestParam(name = "pageNumber", defaultValue = AppConstant.PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = AppConstant.PAGE_SIZE, required = false) Integer pageSize
    ){
        EmployeeResponse response = employeeService.findAllEmployees(pageNumber,pageSize);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/employees/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@Valid @RequestBody EmployeeDTO employeeDTO,
                                                      @PathVariable Long employeeId){
        EmployeeDTO employee = employeeService.updateEmployee(employeeDTO,employeeId);

        return new  ResponseEntity<>(employee, HttpStatus.OK);
    }

    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<EmployeeDTO> deleteEmployee(@PathVariable Long employeeId){
        EmployeeDTO employee = employeeService.deleteEmployee(employeeId);

        return new  ResponseEntity<>(employee, HttpStatus.OK);
    }
}
