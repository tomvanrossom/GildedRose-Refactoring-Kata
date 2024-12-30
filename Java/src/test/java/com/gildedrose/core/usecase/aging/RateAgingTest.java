package com.gildedrose.core.usecase.aging;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateAgingTest {

    private int minQuality = 1;
    private int maxQuality = 50;
    private int rate = -5;
    private RateAging rateAging = new RateAging(rate, minQuality, maxQuality);

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
