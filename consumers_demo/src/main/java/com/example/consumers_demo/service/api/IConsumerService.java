package com.example.consumers_demo.service.api;

import com.example.consumers_demo.dao.entity.Consumer;
import com.example.consumers_demo.service.dto.SaveConsumerDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.UUID;

public interface IConsumerService {
    Consumer create(@Valid SaveConsumerDto saveConsumerDto);

    Consumer get(UUID uuid);

    Page<Consumer> getAll(Pageable pageable);

    Consumer update(UUID uuid, LocalDateTime dt_update, @Valid SaveConsumerDto userDto);

    void delete(UUID uuid,LocalDateTime dt_update);
}
