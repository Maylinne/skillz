package com.example.skills.dto;

import com.example.skills.entity.Difficulty;
import com.example.skills.entity.SkillDefinitionDifficulty;
import com.example.skills.entity.SkillType;

import java.util.Objects;

public sealed abstract class SkillDto
        permits PercentSkillDto, LevelSkillDto{

    protected Long id;
    protected String name;
    protected SkillType type;
    protected AttributeName attributeName;
    protected int attributeValue;
    protected Long playerId;
    protected SkillDefinitionDifficulty difficulty;
    protected Category category;

    public SkillDto(Long id, String name, SkillType type, AttributeName attributeName, int attributeValue, Long playerId, SkillDefinitionDifficulty difficulty) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.attributeName = attributeName;
        this.attributeValue = attributeValue;
        this.playerId = playerId;
        this.difficulty = difficulty;
    }

    public SkillDto() {
    }

    public abstract void addKp(int kp);

    public abstract int getKp();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SkillType getType() {
        return type;
    }

    public void setType(SkillType type) {
        this.type = type;
    }

    public AttributeName getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(AttributeName attributeName) {
        this.attributeName = attributeName;
    }

    public int getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(int attributeValue) {
        this.attributeValue = attributeValue;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public SkillDefinitionDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(SkillDefinitionDifficulty difficulty) {
        this.difficulty = difficulty;
    }
}
