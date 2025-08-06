package com.example.skills.mapper;

import com.example.skills.dto.AttributeDto;
import com.example.skills.entity.AttributeEntity;
import com.example.skills.entity.PlayerEntity;

public class AttributeMapper {

    private AttributeMapper() {}

    public static AttributeDto toDto(AttributeEntity entity) {
        return new AttributeDto(
                entity.getId(),
                entity.getName(),
                entity.getValue(),
                entity.getPlayer() != null ? entity.getPlayer().getId() : null
        );
    }

    public static AttributeEntity toEntity(AttributeDto dto, PlayerEntity player) {
        AttributeEntity entity = new AttributeEntity(dto.getName(), dto.getValue());
        entity.setId(dto.getId());
        entity.setPlayer(player);
        return entity;
    }
}
