package com.gildedrose.core.usecase.aging;

import com.gildedrose.core.domain.Range;
import com.gildedrose.core.usecase.selectable.Selectable;

class StepRange implements Selectable<Integer> {
    private final int amount;

    private final Range sellInRange;

    public StepRange(int rate, Range sellInRange) {
        this.amount = rate;
        this.sellInRange = sellInRange;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean matches(Integer sellIn) {
        return sellInRange.isInRange(sellIn);
    }
}
