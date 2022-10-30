package com.example.it_academy_users.service.converters;

import com.example.it_academy_users.dao.entity.User;
import com.example.it_academy_users.dao.entity.enums.ERole;
import com.example.it_academy_users.service.dto.SaveUserDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SaveUserDtoToUserConverter implements Converter<SaveUserDto, User> {
    @Override
    public User convert(SaveUserDto source) {
        return User.Builder.create()
                .setName(source.getName())
                .setSurname(source.getSurname())
                .setPatronymic(source.getPatronymic())
                .setEmail(source.getEmail())
                .setRole(ERole.valueOf(source.getRole()))
                .build();
    }
}
