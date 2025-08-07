package com.example.skills.entity;

import com.example.skills.dto.AttributeName;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PlayerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Race race;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private final List<AttributeEntity> attributes = new ArrayList<>();

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private final List<SkillEntity> skills = new ArrayList<>();

    public PlayerEntity() {}

    public PlayerEntity(String name, Race race) {
        this.name = name;
        this.race = race;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Race getRace() {
        return race;
    }

    public List<AttributeEntity> getAttributes() {
        return attributes;
    }

    public List<SkillEntity> getSkills() {
        return skills;
    }

    public AttributeEntity getAttribute(AttributeName name) {
        return attributes.stream()
                .filter(attr -> attr.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Attribute not found: " + name));
    }

    public void addAttribute(AttributeEntity attribute) {
        attribute.setPlayer(this);
        this.attributes.add(attribute);
    }

    public void setAttributes(List<AttributeEntity> attributes) {
        if (attributes != null) {
            this.attributes.clear();
            attributes.forEach(this::addAttribute); // reuse the helper
        }
    }

    public void addSkill(SkillEntity skill) {
        skill.setPlayer(this);
        this.skills.add(skill);
    }

    public void setSkills(List<SkillEntity> skills) {
        if (skills != null) {
            this.skills.clear();
            skills.forEach(this::addSkill); // reuse the helper
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRace(Race race) {
        this.race = race;
    }
}
