package com.example.skills.entity;

import com.example.skills.dto.AttributeName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "attribute_entity")
public class AttributeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private AttributeName name;

    @Column(name = "attribute_value")
    private int value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id")
    @JsonIgnore
    private PlayerEntity player;

    public AttributeEntity() {}
    public AttributeEntity(AttributeName name, int value) {
        this.name = name;
        this.value = value;
    }

    public void setPlayer(PlayerEntity player) {
        this.player = player;
    }

    public Long getId() {
        return id;
    }

    public PlayerEntity getPlayer() {
        return player;
    }

    public AttributeName getName() { return name; }
    public int getValue() { return value; }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(AttributeName name) {
        this.name = name;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
