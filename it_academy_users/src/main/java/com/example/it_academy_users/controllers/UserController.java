package com.example.it_academy_users.controllers;

import com.example.it_academy_users.controllers.api.IUserController;
import com.example.it_academy_users.dao.entity.User;
import com.example.it_academy_users.service.api.IUserService;
import com.example.it_academy_users.service.dto.SaveUserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController implements IUserController {
    private final IUserService service;

    public UserController(IUserService service) {
        this.service = service;
    }

    @Override
    @PostMapping
    public ResponseEntity<User> create(@RequestBody SaveUserDto saveUserDto) {
        return new ResponseEntity<>(service.create(saveUserDto), HttpStatus.OK);
    }

    @Override
    @GetMapping
    public ResponseEntity<Page<User>> getAll(@RequestParam(required = false, defaultValue = "0", name = "page") Integer page,
                                             @RequestParam(required = false, defaultValue = "10", name = "size") Integer size) {
        return new ResponseEntity<>(service.getAll(PageRequest.of(page, size, Sort.by("email"))), HttpStatus.OK);
    }

    @Override
    @GetMapping("/{uuid}")
    public ResponseEntity<User> get(@PathVariable UUID uuid) {
        return new ResponseEntity<>(service.get(uuid), HttpStatus.OK);
    }

    @Override
    @PutMapping("/{uuid}/dt_update/{dt_update}")
    public ResponseEntity<User> update(@PathVariable UUID uuid, @PathVariable LocalDateTime dt_update, @RequestBody SaveUserDto userDto) {
        return new ResponseEntity<>(service.update(uuid, dt_update, userDto), HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{uuid}/dt_update/{dt_update}")
    public ResponseEntity<HttpStatus> delete(@PathVariable UUID uuid, @PathVariable LocalDateTime dt_update) {
        service.delete(uuid, dt_update);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
