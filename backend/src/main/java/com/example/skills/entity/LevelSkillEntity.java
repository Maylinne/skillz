package com.example.skills.entity;

import com.example.skills.dto.AttributeName;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("LEVEL")
public class LevelSkillEntity extends SkillEntity {

    private int kp;

    @Transient
    private int level;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    public LevelSkillEntity(String name, AttributeEntity attribute, PlayerEntity player, Difficulty difficulty, int kp) {
        this.name = name;
        this.attribute = attribute;
        this.player = player;
        this.difficulty = difficulty;
        this.kp = kp;
    }

    public LevelSkillEntity() {}


    public int getKp() {
        return kp;
    }

    public int getLevel() {
        return level;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public AttributeName getAttributeName() {
        return attribute.getName();
    }

    public int getAttributeValue() {
        return attribute.getValue();
    }

    public Long getPlayerId() {
        return  player.getId();
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }
}
