package com.example.skills.mapper;

import com.example.skills.dto.*;
import com.example.skills.entity.Difficulty;
import com.example.skills.entity.SkillDefinitionEntity;

public class DefinitionMapper {

    public static SkillDto toSkill(SkillDefinitionDto definition, PlayerDto player, int kp) {
        if (definition == null || definition.getDifficulty() == null || definition.getAttribute() == null) {
            throw new IllegalArgumentException("Definition, difficulty, and attribute must not be null");
        }

        SkillDto skill;

        String name = definition.getName();
        AttributeName attribute = definition.getAttribute();
        int baseValue = player.getAttributeValueOf(attribute);

        switch (definition.getDifficulty()) {
            case PERCENT ->
                    skill = new PercentSkillDto(null, name, attribute, baseValue, player.getId(), kp);
            case EASY, NORMAL, HARD, VERY_HARD, KNOWLEDGE ->
                    skill = new LevelSkillDto(null, name, attribute, baseValue, player.getId(), Difficulty.valueOf(definition.getDifficulty().name()), kp);
            default -> throw new IllegalStateException("Unhandled difficulty: " + definition.getDifficulty());
        }

        return skill;
    }

    public static SkillDefinitionDto toDto(SkillDefinitionEntity entity) {
        return new SkillDefinitionDto(
                entity.getId(),
                entity.getName(),
                entity.getDifficulty(),
                entity.getAttribute()
        );
    }
}
