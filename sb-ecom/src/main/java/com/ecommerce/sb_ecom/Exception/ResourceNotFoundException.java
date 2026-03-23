package com.ecommerce.sb_ecom.Exception;

public class ResourceNotFoundException extends RuntimeException {
    String resourceName;
    String field;
    String fieldName;
    Long fieldId;

    public ResourceNotFoundException( String resourceName, String field, String fieldName) {
        super(String.format("%s not found %s: %s",resourceName,fieldName,field));
        this.resourceName = resourceName;
        this.field = field;
        this.fieldName = fieldName;
    }
    public ResourceNotFoundException( String resourceName, String field, Long fieldId) {
        super(String.format("%s not found %s: %s",resourceName,field,fieldId));
        this.resourceName = resourceName;
        this.field = field;
        this.fieldId = fieldId;
    }

}
