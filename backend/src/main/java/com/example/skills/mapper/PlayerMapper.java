package com.example.skills.mapper;

import com.example.skills.dto.*;
import com.example.skills.entity.*;

import java.util.List;
import java.util.stream.Collectors;

public class PlayerMapper {

    public static PlayerDto toDto(PlayerEntity entity) {
        return new PlayerDto(
                entity.getId(),
                entity.getName(),
                entity.getRace(),
                entity.getAttributes().stream()
                        .map(AttributeMapper::toDto)
                        .collect(Collectors.toList()),
                entity.getSkills().stream()
                        .map(SkillMapper::toDto)
                        .collect(Collectors.toList())
        );
    }

    public static PlayerEntity toEntity(PlayerDto dto) {
        PlayerEntity player = new PlayerEntity(dto.getName(), dto.getRace());

        for (AttributeDto attrDto : dto.getAttributes()) {
            AttributeEntity attribute = AttributeMapper.toEntity(attrDto, player);
            player.addAttribute(attribute);
        }

        for (var skillDto : dto.getSkills()) {
            SkillEntity skill = SkillMapper.toEntity(skillDto, player);
            player.addSkill(skill);
        }

        return player;
    }

}
