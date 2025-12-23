package com.iamnana.EmployeeManagerBackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long employeeId;

    @NotBlank(message = "Employee name is required.")
    private String name;

    @NotBlank(message = "Employee email is required.")
    private String email;

    @NotBlank(message = "Specify employer position.")
    private String jobTitle;

    private String phone;

    private String imageUrl;
    @Column(nullable = false, updatable = false)
    private String employeeCode;
}
