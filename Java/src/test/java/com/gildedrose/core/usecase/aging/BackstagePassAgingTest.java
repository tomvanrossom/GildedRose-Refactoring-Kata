package com.gildedrose.core.usecase.aging;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BackstagePassAgingTest {

    private final AgingFunction aging = AgingFunctions.backstagePasses();

    @Test
    void nextQualityShouldBeZeroAfterConvert() {
        //given
        int newSellIn = -1;
        int oldQuality = 2;

        //when
        int actual = aging.nextQuality(newSellIn, oldQuality);

        //then
        assertEquals(0,actual, "Should not be negative");
    }

    @Test
    void nextQualityShouldIncreaseBy1() {
        //given
        int newSellIn = 15;
        int oldQuality = 2;

        //when
        int actual = aging.nextQuality(newSellIn, oldQuality);

        //then
        assertEquals(3,actual, "Should increase by 1");
    }

    @Test
    void nextQualityShouldIncreaseBy2ThenDaysBefore() {
        //given
        int newSellIn = 9;
        int oldQuality = 2;

        //when
        int actual = aging.nextQuality(newSellIn, oldQuality);

        //then
        assertEquals(4,actual, "Should increase by 2");
    }

    @Test
    void nextQualityShouldIncreaseBy3FiveDaysBefore() {
        //given
        int newSellIn = 4;
        int oldQuality = 2;

        //when
        int actual = aging.nextQuality(newSellIn, oldQuality);

        //then
        assertEquals(5,actual, "Should increase by 2");
    }
}
