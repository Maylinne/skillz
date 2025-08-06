package com.example.skills.entity;
import com.example.skills.dto.AttributeName;
import com.example.skills.dto.Category;
import jakarta.persistence.*;

@Entity
public class SkillDefinitionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private SkillDefinitionDifficulty difficulty;

    @Enumerated(EnumType.STRING)
    private AttributeName attribute;

    @Enumerated(EnumType.STRING)
    private Category category;

    public SkillDefinitionEntity() {}

    public SkillDefinitionEntity(String name, SkillDefinitionDifficulty difficulty, AttributeName attribute, Category category) {
        this.name = name;
        this.difficulty = difficulty;
        this.attribute = attribute;
        this.category = category;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
