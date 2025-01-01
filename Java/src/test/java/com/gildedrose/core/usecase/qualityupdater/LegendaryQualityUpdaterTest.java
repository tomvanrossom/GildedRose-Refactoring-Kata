package com.gildedrose.core.usecase.qualityupdater;

import com.gildedrose.Item;
import com.gildedrose.core.usecase.aging.AgingFunctions;
import org.junit.jupiter.api.Test;

import static com.gildedrose.core.domain.SpecialNames.SULFURAS;
import static com.gildedrose.core.usecase.selectable.Selectables.byName;
import static com.gildedrose.core.usecase.sellin.Config.fixed;
import static org.junit.jupiter.api.Assertions.*;

class LegendaryQualityUpdaterTest {

    private final LegendaryQualityUpdater updater = new LegendaryQualityUpdater(AgingFunctions.legendary(), fixed(), byName(SULFURAS));

    @Test
    void updateQualityNeverChanges() {
        //given
        Item item = new Item(SULFURAS.fullName, 5, 50);

        //when
        updater.updateQuality(item);

        //then
        assertEquals(80, item.quality);
        assertEquals(5, item.sellIn);
    }

    @Test
    void matchesSulfuras(){
        //given
        Item item = new Item(SULFURAS.fullName, 5, 50);

        //when
        boolean actual = updater.matches(item);

        //then
        assertTrue(actual);
    }
}
