package com.iamnana.EmployeeManagerBackend.payload;

import lombok.Data;

import java.util.List;

@Data
public class EmployeeResponse {
    private List<EmployeeDTO> content;
    private Integer pageNumber;
    private Integer pageSize;
    private Long totalElements;
    private Integer totalPages;
    private boolean lastPage;
}
