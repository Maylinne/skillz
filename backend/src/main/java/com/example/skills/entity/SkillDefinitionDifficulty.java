package com.example.skills.entity;

public enum SkillDefinitionDifficulty {
    KNOWLEDGE,
    EASY,
    NORMAL,
    HARD,
    VERY_HARD,
    PERCENT;

    public static SkillDefinitionDifficulty from(Difficulty difficulty) {
        return switch (difficulty) {
            case KNOWLEDGE -> SkillDefinitionDifficulty.KNOWLEDGE;
            case EASY -> SkillDefinitionDifficulty.EASY;
            case NORMAL -> SkillDefinitionDifficulty.NORMAL;
            case HARD -> SkillDefinitionDifficulty.HARD;
            case VERY_HARD -> SkillDefinitionDifficulty.VERY_HARD;
        };
    }
}
