package com.example.skills.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;


public class AttributeDto {

    private Long id;

    @NotNull
    private AttributeName name;

    @Min(3)
    @Max(20)
    private int value;

    private Long playerId;

    public AttributeDto() {
    }

    public AttributeDto(
            Long id,
            AttributeName name,
            int value,
            Long playerId // nullable for creation if player is assigned separately
    ) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.playerId = playerId;
    }

    public AttributeDto(AttributeName name, int value) {
        this.name = name;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AttributeName getName() {
        return name;
    }

    public void setName(AttributeName name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }
}
