package com.gildedrose.core.usecase.selectable;

import com.gildedrose.core.domain.Article;

public class SelectsAll implements Selectable<Article> {
    @Override
    public boolean matches(Article article) {
        return true;
    }
}
