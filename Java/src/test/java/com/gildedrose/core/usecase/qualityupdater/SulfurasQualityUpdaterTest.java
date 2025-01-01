package com.gildedrose.core.usecase.qualityupdater;

import com.gildedrose.core.domain.Article;
import com.gildedrose.core.domain.TestArticle;
import org.junit.jupiter.api.Test;

import static com.gildedrose.core.domain.SpecialNames.SULFURAS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SulfurasQualityUpdaterTest {

    private final SelectableQualityUpdater updater = Config.sulfuras();

    @Test
    void updateQualityNeverChanges() {
        //given
        Article article = new TestArticle(SULFURAS.fullName, 5, 50);

        //when
        updater.updateQuality(article);

        //then
        assertEquals(80, article.getQuality());
        assertEquals(5, article.getSellIn());
    }

    @Test
    void matchesSulfuras(){
        //given
        Article article = new TestArticle(SULFURAS.fullName, 5, 50);

        //when
        boolean actual = updater.matches(article);

        //then
        assertTrue(actual);
    }
}
