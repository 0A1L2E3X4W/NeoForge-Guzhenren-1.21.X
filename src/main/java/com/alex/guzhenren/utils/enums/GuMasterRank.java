package com.alex.guzhenren.utils.enums;

public enum GuMasterRank {

    MORTAL("guzhenren.rank.mortal",0, 0, 0),

    // RANK ONE
    RANK_ONE_INIT("guzhenren.rank.one_init", 1, 1.00f, 0),
    RANK_ONE_MID("guzhenren.rank.one_mid", 1, 1.50f, 1000),
    RANK_ONE_UPPER("guzhenren.rank.one_upper", 1, 2.50f, 1500),
    RANK_ONE_PEAK("guzhenren.rank.one_peak", 1, 4.00f, 2000),

    // RANK TWO
    RANK_TWO_INIT("guzhenren.rank.two_init", 2, 5.00f, 0),
    RANK_TWO_MID("guzhenren.rank.two_mid", 2, 5.50f, 3000),
    RANK_TWO_UPPER("guzhenren.rank.two_upper", 2, 6.50f, 3500),
    RANK_TWO_PEAK("guzhenren.rank.two_peak", 2, 8.00f, 4000);

    private final String nameKey;
    private final int rank;
    private final float essenceModifier;
    private final int maxProgress;

    GuMasterRank(String key, int v, float modifier, int maxProgress) {
        this.nameKey = key;
        this.rank = v;
        this.essenceModifier = modifier;
        this.maxProgress = maxProgress;
    }

    public String getNameKey() { return nameKey; }
    public float getEssenceModifier() { return essenceModifier; }
    public int getRankNum() { return rank; }
    public int getMaxProgress() { return maxProgress; }
}
