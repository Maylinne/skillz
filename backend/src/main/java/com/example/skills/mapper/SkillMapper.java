package com.example.skills.mapper;

import com.example.skills.dto.LevelSkillDto;
import com.example.skills.dto.PercentSkillDto;
import com.example.skills.dto.SkillDto;
import com.example.skills.entity.*;

import static com.example.skills.entity.SkillType.LEVEL;
import static com.example.skills.entity.SkillType.PERCENT;

public class SkillMapper {

    private SkillMapper() {
        // utility class, do not instantiate
    }

    public static SkillDto toDto(SkillEntity skill) {
        return switch (skill) {
            case PercentSkillEntity percentSkill -> PercentSkillMapper.toDto(percentSkill);
            case LevelSkillEntity levelSkill -> LevelSkillMapper.toDto(levelSkill);
            default -> throw new IllegalArgumentException("Unsupported skill type: " + skill.getClass());
        };
    }

    public static SkillEntity toEntity(SkillDto dto, PlayerEntity player) {
        return switch (dto) {
            case PercentSkillDto percentSkill -> PercentSkillMapper.toEntity(percentSkill, player);
            case LevelSkillDto levelSkill -> LevelSkillMapper.toEntity(levelSkill, player);
        };
    }

}
