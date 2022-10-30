package com.example.it_academy_users.service.dto.errors;

import java.util.List;
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
