package com.example.it_academy_users.service.dto;

import com.example.it_academy_users.dao.entity.enums.ERole;
import com.example.it_academy_users.service.validators.api.ValueOfEnum;

import javax.validation.constraints.*;

public class SaveUserDto {
    @NotNull
    @NotBlank
    @Size(min = 2, max = 40)
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Разрешены только Латинские символы")
    private String name;
    @NotNull
    @NotBlank
    @Size(min = 2, max = 20)
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Разрешены только Латинские символы")
    private String surname;
    @NotNull
    @NotBlank
    @Size(min = 2, max = 40)
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Разрешены только Латинские символы")
    private String patronymic;
    @Email
    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    private String email;
    @ValueOfEnum(enumClass = ERole.class, message = "Некорректная роль")
    private String role;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
