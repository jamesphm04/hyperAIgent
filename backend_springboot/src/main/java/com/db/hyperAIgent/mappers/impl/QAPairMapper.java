package com.db.hyperAIgent.mappers.impl;

import com.db.hyperAIgent.domain.dtos.QAPairDto;
import com.db.hyperAIgent.domain.entities.QAPairEntity;
import com.db.hyperAIgent.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class QAPairMapper implements Mapper<QAPairEntity, QAPairDto> {

    final private ModelMapper modelMapper;

    public QAPairMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public QAPairDto mapTo(QAPairEntity qAPairEntity) {
        return modelMapper.map(qAPairEntity, QAPairDto.class);
    }

    @Override
    public QAPairEntity mapFrom(QAPairDto qAPairDto) {
        return modelMapper.map(qAPairDto, QAPairEntity.class);
    }
}
