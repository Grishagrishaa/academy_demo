package com.example.it_academy_users.dao.api;

import com.example.it_academy_users.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IUserDao extends JpaRepository<User, UUID> {
}
