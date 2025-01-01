package com.gildedrose.core.usecase.selectable;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static com.gildedrose.core.domain.SpecialNames.CONJURED;
import static com.gildedrose.core.domain.SpecialNames.SULFURAS;
import static com.gildedrose.core.usecase.selectable.Config.byName;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SelectableByNameTest {

    @Test
    void matchesConfigured() {
        //given
        Selectable selectable = byName(SULFURAS);
        Item item = new Item(SULFURAS.fullName, 5, 10);

        //when
        boolean actual = selectable.matches(item);

        assertTrue(actual);
    }

    @Test
    void matchesFalseWithOther() {
        //given
        Selectable selectable = byName(SULFURAS);
        Item item = new Item(CONJURED.fullName, 5, 10);

        //when
        boolean actual = selectable.matches(item);

        assertFalse(actual);
    }
}
