package com.iamnana.EmployeeManagerBackend.exception;

public class ResourcesNotFoundException extends RuntimeException {
    private String resourceName;
    private String field;
    private String fieldName;
    private Long fieldId;

    public ResourcesNotFoundException() {
    }

    public ResourcesNotFoundException(String resourceName, String field, String fieldName, String fieldId) {
        super(String.format("%s not found with %s: %s ", resourceName, field, fieldName));
        this.resourceName = resourceName;
        this.field = field;
        this.fieldName = fieldName;
    }

    public ResourcesNotFoundException(String resourceName, String field, Long fieldId) {
        super(String.format("%s not found with %s: %d ", resourceName, field, fieldId));
        this.resourceName = resourceName;
        this.field = field;
        this.fieldId = fieldId;

    }

}
