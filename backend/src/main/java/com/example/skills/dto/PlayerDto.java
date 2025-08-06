package com.example.skills.dto;

import com.example.skills.entity.Race;
import java.util.ArrayList;
import java.util.List;

public class PlayerDto {
    private Long id;
    private String name;
    private Race race;
    private List<AttributeDto> attributes = new ArrayList<>();
    private List<SkillDto> skills = new ArrayList<>();

    public PlayerDto(String name, Race race) {
        this.name = name;
        this.race = race;
    }

    public PlayerDto(Long id, String name, Race race, List<AttributeDto> attributes, List<SkillDto> skills) {
        this.id = id;
        this.name = name;
        this.race = race;
        this.attributes = attributes;
        this.skills = skills;
    }

    public int getAttributeValueOf(AttributeName attributeName) {
        AttributeDto attribute = attributes.stream()
                .filter(attr -> attr.getName() == attributeName)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Attribute not found: " + attributeName));

        return attribute.getValue();
    }

    public void addSkill(SkillDto skill) {
        skills.add(skill);
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

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public List<AttributeDto> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<AttributeDto> attributes) {
        this.attributes = attributes;
    }

    public List<SkillDto> getSkills() {
        return skills;
    }

    public void setSkills(List<SkillDto> skills) {
        this.skills = skills;
    }
}
