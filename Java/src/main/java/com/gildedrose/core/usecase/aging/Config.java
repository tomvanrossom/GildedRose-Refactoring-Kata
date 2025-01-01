package com.gildedrose.core.usecase.aging;

import com.gildedrose.core.domain.Range;

import static com.gildedrose.core.domain.Range.from;
import static com.gildedrose.core.domain.Range.full;
import static java.util.Arrays.asList;

public class Config {

    public static Range standardQualityRange() { return from(0).toInclusive(50).build();};
    public static Range legendaryQualityRange() { return from(80).toInclusive(80).build();};

    static AgingFunction simpleAging(int amount){
        StepRange normal = new StepRange(amount, from(0).build());
        StepRange overdue = new StepRange(2 * amount, from(Integer.MIN_VALUE).toExclusive(0).build());

        return new SellInStepsAging(asList(normal, overdue), standardQualityRange());
    }

    public static AgingFunction singleDegrading(){
        return simpleAging(-1);
    }

    public static AgingFunction doubleDegrading(){
        return simpleAging(-2);
    }

    public static AgingFunction improving(){
        StepRange normal = new StepRange(1, full());

        return new SellInStepsAging(asList(normal), standardQualityRange());
    }

    public static AgingFunction backstagePasses(){
        StepRange normal = new StepRange(1, from(10).build());
        StepRange tenDaysBefore = new StepRange(2, from(5).toExclusive(10).build());
        StepRange fiveDaysBefore = new StepRange(3, from(0).toExclusive(5).build());

        int dropToZero = Integer.MIN_VALUE;
        StepRange overdue = new StepRange(dropToZero, from(Integer.MIN_VALUE).toExclusive(0).build());

        return new SellInStepsAging(asList(normal, tenDaysBefore, fiveDaysBefore, overdue), standardQualityRange());
    }

    public static AgingFunction legendary(){
        int neverChange = 0;
        StepRange normal = new StepRange(neverChange, full());

        return new SellInStepsAging(asList(normal), legendaryQualityRange());
    }
}
