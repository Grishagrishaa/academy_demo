package com.example.consumers_demo.controllers.api;

import com.example.consumers_demo.dao.entity.Consumer;
import com.example.consumers_demo.service.dto.SaveConsumerDto;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public interface IConsumerController {
    ResponseEntity<Consumer> create(SaveConsumerDto saveConsumerDto);

    ResponseEntity<Page<Consumer>> getAll(Integer page, Integer size);

    ResponseEntity<Consumer> get(UUID uuid);

    ResponseEntity<Consumer> update(UUID uuid, LocalDateTime dt_update, SaveConsumerDto userDto);

    ResponseEntity<HttpStatus> delete(UUID uuid, LocalDateTime dt_update);
}
