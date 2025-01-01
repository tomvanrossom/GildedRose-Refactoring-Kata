package com.gildedrose.core.usecase.qualityupdater;

import java.util.List;

import static com.gildedrose.core.domain.SpecialNames.*;
import static com.gildedrose.core.usecase.aging.Config.*;
import static com.gildedrose.core.usecase.selectable.Config.all;
import static com.gildedrose.core.usecase.selectable.Config.byName;
import static com.gildedrose.core.usecase.sellin.Config.fixed;
import static com.gildedrose.core.usecase.sellin.Config.simple;
import static java.util.Arrays.asList;

public class Config {

    static QualityUpdater standardQU() {
        return new GenericQualityUpdater(all(), simple(), singleDegrading());
    }
    static SelectableQualityUpdater backStagePassesQU() {
        return new GenericQualityUpdater(byName(BACKSTAGE_PASSES), simple(), backstagePasses());
    }
    static SelectableQualityUpdater sulfuras() {
        return new GenericQualityUpdater(byName(SULFURAS), fixed(), legendary());

    }
    static SelectableQualityUpdater agedBrieQU() {
        return new GenericQualityUpdater(byName(AGED_BRIE), simple(), improving());
    }
    static SelectableQualityUpdater conjuredQU() {
        return new GenericQualityUpdater(byName(CONJURED), simple(), doubleDegrading());
    }

    static List<SelectableQualityUpdater> specificQUs(){
        return asList(agedBrieQU(), sulfuras(), backStagePassesQU(), conjuredQU());
    }

    public static QualityUpdater qualityUpdater(){
        return new QualityUpdaterSelector(standardQU(), specificQUs());
    }
}
