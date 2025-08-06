package com.example.skills.entity;

public enum Difficulty {

    KNOWLEDGE(new int[]{1, 3, 5, 10, 20}),
    EASY(new int[]{1, 3, 8, 15, 25}),
    NORMAL(new int[]{1, 5, 10, 20, 30}),
    HARD(new int[]{2, 8, 15, 30, 45}),
    VERY_HARD(new int[]{3, 10, 20, 35, 55});

    private final int[] thresholds;

    Difficulty(int[] thresholds) {
        this.thresholds = thresholds;
    }

    public int[] thresholds() {
        return thresholds;
    }
}
