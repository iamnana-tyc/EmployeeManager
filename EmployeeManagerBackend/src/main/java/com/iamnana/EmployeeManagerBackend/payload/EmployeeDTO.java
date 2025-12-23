package com.iamnana.EmployeeManagerBackend.payload;

import lombok.Data;

@Data
public class EmployeeDTO {
    private Long employeeId;

    private String name;

    private String email;

    private String jobTitle;

    private String phone;

    private String imageUrl;

    private String employeeCode;
}
