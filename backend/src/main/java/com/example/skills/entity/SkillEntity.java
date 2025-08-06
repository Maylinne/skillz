package com.example.skills.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "skill_type")
public abstract class SkillEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attribute_id")
    protected AttributeEntity attribute;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id")
    @JsonIgnore
    protected PlayerEntity player;



    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public AttributeEntity getAttribute() {
        return attribute;
    }

    public PlayerEntity getPlayer() {
        return player;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAttribute(AttributeEntity attribute) {
        this.attribute = attribute;
    }

    public void setPlayer(PlayerEntity player) {
        this.player = player;
    }

}
