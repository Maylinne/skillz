package com.example.skills.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record NamedSkillDto(

        @NotNull
        SkillDefinitionDto skillDef,

        @Min(0)
        int value
) {}
