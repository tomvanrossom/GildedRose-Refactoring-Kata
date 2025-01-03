package com.gildedrose.core.usecase.selectable;

import com.gildedrose.core.domain.SpecialNames;

public class Config {
    public static Selectable byName(SpecialNames name){
        return new SelectableByName(name);
    }

    public static Selectable all(){
        return new SelectsAll();
    }
}
