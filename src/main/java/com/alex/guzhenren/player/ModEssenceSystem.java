package com.alex.guzhenren.player;

public record ModEssenceSystem(int maxVal, float currentVal) {

    public ModEssenceSystem {
        if (currentVal > maxVal) currentVal = maxVal;
        if (currentVal < 0f) currentVal = 0f;
    }

    public ModEssenceSystem setCurrentEssence(float newValue) {
        newValue = Math.min(Math.max(newValue, 0f), maxVal);
        return new ModEssenceSystem(maxVal, newValue);
    }

    public ModEssenceSystem setMaxEssence(int newMax) {
        float clampedCurrent = Math.min(currentVal, newMax);
        return new ModEssenceSystem(newMax, clampedCurrent);
    }
}
