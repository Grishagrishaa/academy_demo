package com.example.consumers_demo.service;

import com.example.consumers_demo.dao.api.IConsumerDao;
import com.example.consumers_demo.dao.entity.Consumer;
import com.example.consumers_demo.dao.entity.enums.ERole;
import com.example.consumers_demo.service.api.IConsumerService;
import com.example.consumers_demo.service.dto.SaveConsumerDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.persistence.OptimisticLockException;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Validated
@Transactional(readOnly = true)
public class ConsumerService implements IConsumerService {
    private final IConsumerDao dao;
    private final ConversionService conversionService;
    private static final Logger log = LoggerFactory.getLogger(ConsumerService.class);

    public ConsumerService(IConsumerDao dao, ConversionService conversionService) {
        this.dao = dao;
        this.conversionService = conversionService;
    }

    @Override
    @Transactional
    public Consumer create(@Valid SaveConsumerDto saveConsumerDto) {
        Consumer consumer = conversionService.convert(saveConsumerDto, Consumer.class);
        log.debug("Created Consumer - {}", consumer);
        return dao.save(consumer);
    }

    @Override
    public Page<Consumer> getAll(Pageable pageable) {
        log.info("Find all, page - {}, size - {}", pageable.getPageNumber(), pageable.getPageSize());
        return dao.findAll(pageable);
    }

    @Override
    public Consumer get(UUID uuid) {
        return dao.findById(uuid).orElseThrow(() -> new IllegalArgumentException("NOT FOUND | INCORRECT ID"));
    }

    @Override
    @Transactional
    public Consumer update(UUID uuid, LocalDateTime dt_update, @Valid SaveConsumerDto consumerDto) {
        Consumer consumer = get(uuid);

        if(!consumer.getUpdateDate().isEqual(dt_update)){
            log.warn("Optimistic lock");
            throw new OptimisticLockException("USER WAS ALREADY UPDATED");
        }

        updateConsumerData(consumer, consumerDto);

        return dao.save(consumer);
    }

    @Override
    @Transactional
    public void delete(UUID uuid, LocalDateTime dt_update) {
        Consumer consumer = get(uuid);

        if(!consumer.getUpdateDate().isEqual(dt_update)){
            log.warn("OPTIMISTIC LOCK");
            throw new OptimisticLockException("Consumer WAS ALREADY UPDATED");
        }

        dao.delete(consumer);
        log.info("Deleted Consumer - {}", consumer);
    }

    private void updateConsumerData(Consumer consumer, SaveConsumerDto dto){
        consumer.setEmail(dto.getEmail());
        consumer.setName(dto.getName());
        consumer.setSurname(dto.getSurname());
        consumer.setPatronymic(dto.getPatronymic());
        consumer.setRole(ERole.valueOf(dto.getRole()));
    }
}
