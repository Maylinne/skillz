package com.example.skills.entity;

import com.example.skills.dto.AttributeName;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PERCENT")
public class PercentSkillEntity extends SkillEntity {

    private int bonus;

    public PercentSkillEntity() {
    }

    public PercentSkillEntity(String name, AttributeEntity attribute, PlayerEntity player, int bonus) {
        this.name = name;
        this.attribute = attribute;
        this.player = player;
        this.bonus = bonus;
    }

    public AttributeName getAttributeName() {
        return attribute.getName();
    }

    public  int getAttributeValue() {
        return attribute.getValue();
    }

    public  Long getPlayerId() {
        return player.getId();
    }

    public int getBonus() {
        return bonus;
    }
}
