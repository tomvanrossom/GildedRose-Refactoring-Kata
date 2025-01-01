package com.gildedrose.core.usecase.selectable;

import com.gildedrose.core.domain.Article;
import com.gildedrose.core.domain.TestArticle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SelectsAllTest {

    @Test
    void matches() {
        //given
        Selectable<Article> selectable = new SelectsAll();

        //when
        boolean actual = selectable.matches(new TestArticle("abc", 5, 6));

        //then
        assertTrue(actual);
    }
}
