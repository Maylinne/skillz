package com.example.skills.dto;

import com.example.skills.entity.SkillDefinitionDifficulty;
import com.example.skills.entity.SkillType;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "difficulty",     // must be present in JSON before binding
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = PercentSkillDto.class, name = "PERCENT"),
        @JsonSubTypes.Type(value = LevelSkillDto.class,   name = "EASY"),
        @JsonSubTypes.Type(value = LevelSkillDto.class,   name = "NORMAL"),
        @JsonSubTypes.Type(value = LevelSkillDto.class,   name = "HARD"),
        @JsonSubTypes.Type(value = LevelSkillDto.class,   name = "VERY_HARD"),
        @JsonSubTypes.Type(value = LevelSkillDto.class,   name = "KNOWLEDGE")
})
public sealed abstract class SkillDto
        permits PercentSkillDto, LevelSkillDto {

    protected Long id;
    protected String name;
    protected SkillType type;
    protected AttributeName attributeName;
    protected int attributeValue;
    protected Long playerId;
    protected SkillDefinitionDifficulty difficulty;
    protected Category category;

    public SkillDto() {
    }

    public SkillDto(Long id, String name, SkillType type, AttributeName attributeName, int attributeValue, Long playerId, SkillDefinitionDifficulty difficulty) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.attributeName = attributeName;
        this.attributeValue = attributeValue;
        this.playerId = playerId;
        this.difficulty = difficulty;
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
