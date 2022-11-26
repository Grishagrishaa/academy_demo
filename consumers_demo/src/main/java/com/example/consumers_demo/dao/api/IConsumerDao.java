package com.example.consumers_demo.dao.api;

import com.example.consumers_demo.dao.entity.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IConsumerDao extends JpaRepository<Consumer, UUID> {
}
