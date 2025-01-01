package com.gildedrose.core.usecase.aging;

import com.gildedrose.core.domain.Range;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateAgingTest {

    private Range range =  Range.Builder.from(1).toInclusive(50).build();
    private int minQuality = range.getMin();
    private int maxQuality = range.getMax();
    private int rate = -5;
    private RateAging rateAging = new RateAging(rate, range);

    @Test
    void nextQualityShouldNeverBeLessThenMin() {
        //given
        int newSellIn = 5;
        int oldQuality = 2;

        //when
        int actual = rateAging.nextQuality(newSellIn, oldQuality);

        //then
        assertTrue(actual >= minQuality, "Should not be less then min");
    }

    @Test
    void nextQualityShouldNeverBeMoreThenMax() {
        //given
        int newSellIn = 5;
        int oldQuality = 55;

        //when
        int actual = rateAging.nextQuality(newSellIn, oldQuality);

        //then
        assertTrue(actual >= minQuality, "Should not be more then max");
    }

    @Test
    void nextQualityShouldUseCorrectRate() {
        //given
        int newSellIn = 5;
        int oldQuality = 50;

        //when
        int actual = rateAging.nextQuality(newSellIn, oldQuality);

        //then
        assertEquals(actual, 45, "Should be decreased by rate");
    }

    @Test
    void nextQualityShouldUseDoubleRateWhenSellDatePassed() {
        //given
        int newSellIn = -1;
        int oldQuality = 50;

        //when
        int actual = rateAging.nextQuality(newSellIn, oldQuality);

        //then
        assertEquals(actual, 40, "Should be decreased by double rate");
    }
}
