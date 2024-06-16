package com.db.hyperAIgent.mappers.impl;

import com.db.hyperAIgent.domain.dtos.ImageDto;
import com.db.hyperAIgent.domain.entities.ImageEntity;
import com.db.hyperAIgent.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ImageMapper implements Mapper<ImageEntity, ImageDto> {

    final private ModelMapper modelMapper;

    public ImageMapper(ModelMapper modelMapper) { this.modelMapper = modelMapper; }

    @Override
    public ImageDto mapTo(ImageEntity imageEntity) { return modelMapper.map(imageEntity, ImageDto.class); }

    @Override
    public ImageEntity mapFrom(ImageDto imageDto) { return modelMapper.map(imageDto, ImageEntity.class); }
}
