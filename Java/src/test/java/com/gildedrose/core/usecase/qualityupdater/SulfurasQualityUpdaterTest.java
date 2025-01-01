package com.gildedrose.core.usecase.qualityupdater;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static com.gildedrose.core.domain.SpecialNames.SULFURAS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SulfurasQualityUpdaterTest {

    private final SelectableQualityUpdater updater = Config.sulfuras();

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
