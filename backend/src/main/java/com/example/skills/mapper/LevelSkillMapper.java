package com.example.skills.mapper;

import com.example.skills.dto.LevelSkillDto;
import com.example.skills.entity.AttributeEntity;
import com.example.skills.entity.LevelSkillEntity;
import com.example.skills.entity.PlayerEntity;
import org.springframework.stereotype.Service;

@Service
public class LevelSkillMapper {

    public static LevelSkillDto toDto (LevelSkillEntity entity) {
        return new LevelSkillDto(
                entity.getId(),
                entity.getName(),
                entity.getAttributeName(),
                entity.getAttributeValue(),
                entity.getPlayerId(),
                entity.getDifficulty(),
                entity.getKp()
                );
    }

    public static LevelSkillEntity toEntity(LevelSkillDto dto, PlayerEntity player) {
        AttributeEntity attribute = player.getAttributes().stream()
                .filter(attr -> attr.getName().equals(dto.getAttributeName()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Attribute not found: " + dto.getAttributeName()));

        return new LevelSkillEntity(
                dto.getName(),
                attribute,
                player,
                dto.getLevelDifficulty(),
                dto.getKp()
        );
    }
}
