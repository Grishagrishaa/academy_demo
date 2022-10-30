package com.example.it_academy_users.controllers.api;

import com.example.it_academy_users.dao.entity.User;
import com.example.it_academy_users.service.dto.SaveUserDto;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public interface IUserController {
    ResponseEntity<User> create(SaveUserDto saveUserDto);

    ResponseEntity<Page<User>> getAll(Integer page, Integer size);

    ResponseEntity<User> get(UUID uuid);

    ResponseEntity<User> update(UUID uuid,LocalDateTime dt_update, SaveUserDto userDto);

    ResponseEntity<HttpStatus> delete(UUID uuid, LocalDateTime dt_update);
}
