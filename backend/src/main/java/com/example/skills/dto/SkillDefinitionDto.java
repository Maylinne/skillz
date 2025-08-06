package com.example.skills.dto;

import com.example.skills.entity.SkillDefinitionDifficulty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SkillDefinitionDto {

    private Long id;

    @NotBlank
    private String name;

    @NotNull
    private SkillDefinitionDifficulty difficulty;

    @NotNull
    private AttributeName attribute;

    public SkillDefinitionDto(Long id, String name, SkillDefinitionDifficulty difficulty, AttributeName attribute) {
        this.id = id;
        this.name = name;
        this.difficulty = difficulty;
        this.attribute = attribute;
    }

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

    public SkillDefinitionDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(SkillDefinitionDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    public AttributeName getAttribute() {
        return attribute;
    }

    public void setAttribute(AttributeName attribute) {
        this.attribute = attribute;
    }
}
