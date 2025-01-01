package com.gildedrose.core.usecase.aging;

import com.gildedrose.core.domain.InRange;
import com.gildedrose.core.domain.Range;

class StepRange implements InRange {
    private final int amount;

    private final Range range;

    public StepRange(int rate, Range range) {
        this.amount = rate;
        this.range = range;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean isInRange(int value) {
        return range.isInRange(value);
    }
}
