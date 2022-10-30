package com.example.it_academy_users.service;

import com.example.it_academy_users.dao.api.IUserDao;
import com.example.it_academy_users.dao.entity.User;
import com.example.it_academy_users.dao.entity.enums.ERole;
import com.example.it_academy_users.service.api.IUserService;
import com.example.it_academy_users.service.dto.SaveUserDto;
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
public class UserService implements IUserService {
    private final IUserDao dao;
    private final ConversionService conversionService;
    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    public UserService(IUserDao dao, ConversionService conversionService) {
        this.dao = dao;
        this.conversionService = conversionService;
    }

    @Override
    @Transactional
    public User create(@Valid SaveUserDto saveUserDto) {
        User user = conversionService.convert(saveUserDto, User.class);
        log.debug("Created user - {}", user);
        return dao.save(user);
    }

    @Override
    public Page<User> getAll(Pageable pageable) {
        log.info("Find all, page - {}, size - {}", pageable.getPageNumber(), pageable.getPageSize());
        return dao.findAll(pageable);
    }

    @Override
    public User get(UUID uuid) {
        return dao.findById(uuid).orElseThrow(() -> new IllegalArgumentException("NOT FOUND | INCORRECT ID"));
    }

    @Override
    @Transactional
    public User update(UUID uuid, LocalDateTime dt_update, @Valid SaveUserDto userDto) {
        User user = get(uuid);

        if(!user.getUpdateDate().isEqual(dt_update)){
            log.warn("Optimistic lock");
            throw new OptimisticLockException("USER WAS ALREADY UPDATED");
        }

        updateUserData(user, userDto);

        return dao.save(user);
    }

    @Override
    @Transactional
    public void delete(UUID uuid, LocalDateTime dt_update) {
        User user = get(uuid);

        if(!user.getUpdateDate().isEqual(dt_update)){
            log.warn("OPTIMISTIC LOCK");
            throw new OptimisticLockException("USER WAS ALREADY UPDATED");
        }

        dao.delete(user);
        log.info("Deleted user - {}", user);
    }

    private void updateUserData(User user, SaveUserDto dto){
        user.setEmail(dto.getEmail());
        user.setName(dto.getName());
        user.setSurname(dto.getSurname());
        user.setPatronymic(dto.getPatronymic());
        user.setRole(ERole.valueOf(dto.getRole()));
    }
}
