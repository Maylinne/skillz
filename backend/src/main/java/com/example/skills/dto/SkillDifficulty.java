package com.example.skills.dto;

public final class SkillDifficulty {

    private final String name;
    private final int[] thresholds;

    public SkillDifficulty(String name, int[] thresholds) {
        this.name = name;
        this.thresholds = thresholds;
    }

    public String getName() {
        return name;
    }

    public int[] getThresholds() {
        return thresholds;
    }
}
