package com.example.consumers_demo.service.converters;

import com.example.consumers_demo.dao.entity.Consumer;
import com.example.consumers_demo.dao.entity.enums.ERole;
import com.example.consumers_demo.service.dto.SaveConsumerDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SaveConsumerDtoToConsumerConverter implements Converter<SaveConsumerDto, Consumer> {
    @Override
    public Consumer convert(SaveConsumerDto source) {
        return Consumer.Builder.create()
                .setName(source.getName())
                .setSurname(source.getSurname())
                .setPatronymic(source.getPatronymic())
                .setEmail(source.getEmail())
                .setRole(ERole.valueOf(source.getRole()))
                .build();
    }
}
