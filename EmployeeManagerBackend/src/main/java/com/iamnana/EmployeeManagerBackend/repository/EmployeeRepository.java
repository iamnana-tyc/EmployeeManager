package com.iamnana.EmployeeManagerBackend.repository;

import com.iamnana.EmployeeManagerBackend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
