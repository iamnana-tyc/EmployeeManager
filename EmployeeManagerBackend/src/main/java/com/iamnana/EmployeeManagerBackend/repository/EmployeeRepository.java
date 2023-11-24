package com.iamnana.EmployeeManagerBackend.repository;

import com.iamnana.EmployeeManagerBackend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
