package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.core.domain.SpecialNames.*;
import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {

    @Test
    void standardBehavior(){
        //given
        Item[] items = new Item[] { new Item("Standard", 10, 5) };
        GildedRose app = new GildedRose(items);

        //when
        app.updateQuality();

        //then
        assertEquals(4, app.items[0].quality, "quality should decrease");
        assertEquals(9, app.items[0].sellIn, "sellIn should decrease");
    }

    @Test
    void qualityDecreaseDoublesAfterSellDate(){
        //given
        Item[] items = new Item[] { new Item("Standard", 0, 5) };
        GildedRose app = new GildedRose(items);

        //when
        app.updateQuality();

        //then
        assertEquals(3, app.items[0].quality, "quality should decrease");
        //TODO assertEquals(0, app.items[0].sellIn, "sellIn should not be negative");
    }

    @Test
    void agedBrieQualityShouldIncrease(){
        //given
        Item[] items = new Item[] { new Item(AGED_BRIE.fullName, 10, 5) };
        GildedRose app = new GildedRose(items);

        //when
        app.updateQuality();

        //then
        assertEquals(6, app.items[0].quality, "quality should be 6");
    }

    @Test
    void agedBrieQualityShouldNotExceedMax(){
        //given
        Item[] items = new Item[] { new Item(AGED_BRIE.fullName, -1, 48) };
        GildedRose app = new GildedRose(items);

        //when
        app.updateQuality();

        //then
        assertEquals(50, app.items[0].quality, "quality should be 6");
    }

    @Test
    void qualityShouldNeverExceedMax(){
        //given
        Item[] items = new Item[] { new Item(AGED_BRIE.fullName, 10, 50) };
        GildedRose app = new GildedRose(items);

        //when
        app.updateQuality();

        //then
        assertEquals(50, app.items[0].quality, "quality should not exceed max of 50");
    }

    @Test
    void sulfurasIsLegendary(){
        //given
        Item[] items = new Item[] { new Item(SULFURAS.fullName, 10, 50) };
        GildedRose app = new GildedRose(items);

        //when
        app.updateQuality();

        //then
        assertEquals(10, app.items[0].sellIn, "sellIn should not change");
        assertEquals(80, app.items[0].quality, "quality should always be 80");
    }

    @Test
    void backstagePassesQualityShouldIncrease(){
        //given
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES.fullName, 20, 5) };
        GildedRose app = new GildedRose(items);

        //when
        app.updateQuality();

        //then
        assertEquals(19, app.items[0].sellIn, "sellIn should decrease");
        assertEquals(6, app.items[0].quality, "quality should increase");
    }

    @Test
    void backstagePassesQualityShouldIncreaseBy2(){
        //given
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES.fullName, 10, 5) };
        GildedRose app = new GildedRose(items);

        //when
        app.updateQuality();

        //then
        assertEquals(9, app.items[0].sellIn, "sellIn should decrease");
        assertEquals(7, app.items[0].quality, "quality should increase by 2");
    }

    @Test
    void backstagePassesQualityShouldIncreaseBy3(){
        //given
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES.fullName, 5, 5) };
        GildedRose app = new GildedRose(items);

        //when
        app.updateQuality();

        //then
        assertEquals(4, app.items[0].sellIn, "sellIn should decrease");
        assertEquals(8, app.items[0].quality, "quality should increase by 3");
    }

    @Test
    void backstagePassesQualityShouldDropToZero(){
        //given
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES.fullName, 0, 5) };
        GildedRose app = new GildedRose(items);

        //when
        app.updateQuality();

        //then
        assertEquals(-1, app.items[0].sellIn, "sellIn should decrease");
        assertEquals(0, app.items[0].quality, "quality should be zero");
    }

    @Test
    void conjuredQualityShouldDecreaseBy2(){
        //given
        Item[] items = new Item[] { new Item(CONJURED.fullName, 5, 5) };
        GildedRose app = new GildedRose(items);

        //when
        app.updateQuality();

        //then
        assertEquals(4, app.items[0].sellIn, "sellIn should decrease");
        assertEquals(3, app.items[0].quality, "quality should decrease by 2");
    }

}
