package com.example.it_academy_users.service.dto.errors;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorMessage {
    private String logref;
    private String field;
    private String message;

    public ErrorMessage(String message) {
        this.logref = "error";
        this.message = message;
    }

    public ErrorMessage(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getLogref() {
        return logref;
    }

    public void setLogref(String logref) {
        this.logref = logref;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErrorMessage that = (ErrorMessage) o;
        return Objects.equals(logref, that.logref) && Objects.equals(field, that.field) && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logref, field, message);
    }
}
