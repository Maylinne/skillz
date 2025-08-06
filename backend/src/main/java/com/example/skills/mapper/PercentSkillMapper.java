package com.example.skills.mapper;

import com.example.skills.dto.PercentSkillDto;
import com.example.skills.entity.AttributeEntity;
import com.example.skills.entity.PercentSkillEntity;
import com.example.skills.entity.PlayerEntity;

public class PercentSkillMapper {

    public static PercentSkillDto toDto(PercentSkillEntity entity) {
        return new PercentSkillDto(
                entity.getId(),
                entity.getName(),
                entity.getAttributeName(),
                entity.getAttributeValue(),
                entity.getPlayerId(),
                entity.getBonus()
        );
    }

    public static PercentSkillEntity toEntity(PercentSkillDto dto, PlayerEntity player) {
        AttributeEntity attribute = player.getAttributes().stream()
                .filter(attr -> attr.getName().equals(dto.getAttributeName()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Attribute not found: " + dto.getAttributeName()));

        return new PercentSkillEntity(
                dto.getName(),
                attribute,
                player,
                dto.getBonus()
        );
    }
}
