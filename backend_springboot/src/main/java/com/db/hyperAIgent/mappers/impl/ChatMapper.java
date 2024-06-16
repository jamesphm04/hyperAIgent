package com.db.hyperAIgent.mappers.impl;

import com.db.hyperAIgent.domain.dtos.ChatDto;
import com.db.hyperAIgent.domain.entities.ChatEntity;
import com.db.hyperAIgent.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ChatMapper implements Mapper<ChatEntity, ChatDto> {

    final private ModelMapper modelMapper;

    public ChatMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ChatDto mapTo(ChatEntity chatEntity) {
        return modelMapper.map(chatEntity, ChatDto.class);
    }

    @Override
    public ChatEntity mapFrom(ChatDto chatDto) {
        return modelMapper.map(chatDto, ChatEntity.class);
    }

}
