package com.gildedrose.core.usecase.aging;

import com.gildedrose.core.domain.Range;

import java.util.List;

class SellInStepsAging implements AgingFunction{

    private final List<StepRange> steps;

    private final Range qualityRange;

    public SellInStepsAging(List<StepRange> steps, Range qualityRange) {
        this.steps = steps;
        this.qualityRange = qualityRange;
    }

    @Override
    public int nextQuality(int newSellIn, int oldQuality) {
        int amount = steps
            .stream()
            .filter(step -> step.isInRange(newSellIn))
            .findFirst()
            .map(step -> step.getAmount())
            .get();

        int newQuality = oldQuality + amount;

        newQuality = qualityRange.ensureInRange(newQuality);

        return newQuality;
    }
}
