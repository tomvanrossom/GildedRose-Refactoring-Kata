package com.gildedrose.core.usecase.selectable;

import com.gildedrose.core.domain.Article;
import com.gildedrose.core.domain.SpecialNames;

class SelectableByName implements Selectable<Article> {
    private final SpecialNames name;

    SelectableByName(SpecialNames name) {
        this.name = name;
    }

    @Override
    public boolean matches(Article article) {
        return name.equals(article.getName());
    }
}
