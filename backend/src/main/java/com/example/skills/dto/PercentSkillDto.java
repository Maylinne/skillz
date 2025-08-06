package com.example.skills.dto;

import com.example.skills.entity.SkillDefinitionDifficulty;
import com.example.skills.entity.SkillType;

public final class PercentSkillDto extends SkillDto {

    private int bonus;

    public PercentSkillDto(
            Long id,
            String name,
            AttributeName attributeName,
            int attributeValue,
            Long playerId,
            int bonus
    ) {
        super(id, name, SkillType.PERCENT, attributeName, attributeValue, playerId, SkillDefinitionDifficulty.PERCENT);
        this.bonus = bonus;
    }

    public PercentSkillDto() {
    }

    @Override
    public void addKp(int kp) {
        this.bonus += kp;
    }

    @Override
    public int getKp(){
        return bonus;
    }

    public int getTotal() {
        return attributeValue + bonus;
    }


    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}
