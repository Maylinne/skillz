package com.example.skills.dto;

import com.example.skills.entity.Difficulty;
import com.example.skills.entity.SkillDefinitionDifficulty;
import com.example.skills.entity.SkillType;

public final class LevelSkillDto extends SkillDto {

    private Difficulty levelDifficulty;
    private int kp;
    private int kpToNextLevel;
    private int level;

    public LevelSkillDto() {
    }

    public LevelSkillDto(
            Long id,
            String name,
            AttributeName attributeName,
            int attributeValue,
            Long playerId,
            Difficulty levelDifficulty,
            int kp) {
        super(id, name, SkillType.LEVEL, attributeName, attributeValue, playerId, SkillDefinitionDifficulty.from(levelDifficulty));
        this.levelDifficulty = levelDifficulty;
        this.kp = kp;
        recalculate();
    }

    @Override
    public void addKp(int kp) {
        this.kp += kp;
        recalculate();
    }

    private void recalculate() {
        int maxLevel = Math.min(5, Math.max(0, attributeValue - 10));
        int kptoCount = kp;
        int[] thresholds = levelDifficulty.thresholds();

        for  (int i = 0; i < thresholds.length; i++) {
            if (kptoCount >= thresholds[i]) {
                kptoCount -= thresholds[i];
            } else {
                this.level = Math.min(i, maxLevel);
                this.kpToNextLevel = thresholds[i] - kptoCount;
                break;
            }
        }

        // If player has enough KP to surpass all thresholds, level might still be unset
        if (this.level == 0 && kptoCount >= 0) {
            this.level = Math.min(thresholds.length, maxLevel);
            this.kpToNextLevel = 0;
        }
    }

    public Difficulty getLevelDifficulty() {
        return levelDifficulty;
    }

    public void setLevelDifficulty(Difficulty levelDifficulty) {
        this.levelDifficulty = levelDifficulty;
    }

    @Override
    public int getKp() {
        return kp;
    }

    public int getKpToNextLevel() {
        return kpToNextLevel;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
