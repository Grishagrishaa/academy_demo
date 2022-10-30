package com.example.it_academy_users.service.api;

import com.example.it_academy_users.dao.entity.User;
import com.example.it_academy_users.service.dto.SaveUserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.UUID;

public interface IUserService {
    User create(@Valid SaveUserDto saveUserDto);

    User get(UUID uuid);

    Page<User> getAll(Pageable pageable);

    User update(UUID uuid, LocalDateTime dt_update, @Valid SaveUserDto userDto);

    void delete(UUID uuid,LocalDateTime dt_update);
}
