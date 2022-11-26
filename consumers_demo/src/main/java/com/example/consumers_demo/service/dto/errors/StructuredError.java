package com.example.consumers_demo.service.dto.errors;

import java.util.Set;

public class StructuredError {
    private final String logref;
    private final Set<ErrorMessage> errors;

    public StructuredError(Set<ErrorMessage> errors) {
        this.logref = "structured_error";
        this.errors = errors;
    }

    public String getLogref() {
        return logref;
    }

    public Set<ErrorMessage> getErrors() {
        return errors;
    }
}
