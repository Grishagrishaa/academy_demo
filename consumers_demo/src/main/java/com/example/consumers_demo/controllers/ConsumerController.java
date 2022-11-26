package com.example.consumers_demo.controllers;

import com.example.consumers_demo.controllers.api.IConsumerController;
import com.example.consumers_demo.dao.entity.Consumer;
import com.example.consumers_demo.service.api.IConsumerService;
import com.example.consumers_demo.service.dto.SaveConsumerDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/consumers")
public class ConsumerController implements IConsumerController {
    private final IConsumerService service;

    public ConsumerController(IConsumerService service) {
        this.service = service;
    }

    @Override
    @PostMapping
    public ResponseEntity<Consumer> create(@RequestBody SaveConsumerDto saveConsumerDto) {
        return new ResponseEntity<>(service.create(saveConsumerDto), HttpStatus.OK);
    }

    @Override
    @GetMapping
    public ResponseEntity<Page<Consumer>> getAll(@RequestParam(required = false, defaultValue = "0", name = "page") Integer page,
                                                 @RequestParam(required = false, defaultValue = "10", name = "size") Integer size) {
        return new ResponseEntity<>(service.getAll(PageRequest.of(page, size, Sort.by("email"))), HttpStatus.OK);
    }

    @Override
    @GetMapping("/{uuid}")
    public ResponseEntity<Consumer> get(@PathVariable UUID uuid) {
        return new ResponseEntity<>(service.get(uuid), HttpStatus.OK);
    }

    @Override
    @PutMapping("/{uuid}/dt_update/{dt_update}")
    public ResponseEntity<Consumer> update(@PathVariable UUID uuid, @PathVariable LocalDateTime dt_update, @RequestBody SaveConsumerDto userDto) {
        return new ResponseEntity<>(service.update(uuid, dt_update, userDto), HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{uuid}/dt_update/{dt_update}")
    public ResponseEntity<HttpStatus> delete(@PathVariable UUID uuid, @PathVariable LocalDateTime dt_update) {
        service.delete(uuid, dt_update);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
