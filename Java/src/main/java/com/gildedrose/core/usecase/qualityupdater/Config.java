package com.gildedrose.core.usecase.qualityupdater;

import static com.gildedrose.core.domain.SpecialNames.*;
import static com.gildedrose.core.usecase.aging.Config.backstagePasses;
import static com.gildedrose.core.usecase.aging.Config.singleDegrading;
import static com.gildedrose.core.usecase.selectable.Config.all;
import static com.gildedrose.core.usecase.selectable.Config.byName;
import static com.gildedrose.core.usecase.sellin.Config.fixed;
import static com.gildedrose.core.usecase.sellin.Config.simple;
import static java.util.Arrays.asList;

public class Config {

    private static QualityUpdater standard = new GenericQualityUpdater(all(), simple(), singleDegrading());
    private static SelectableQualityUpdater backStagePassesQualityUpdater = new GenericQualityUpdater(byName(BACKSTAGE_PASSES), simple(), backstagePasses());
    static SelectableQualityUpdater legendary = new GenericQualityUpdater(byName(SULFURAS), fixed(), com.gildedrose.core.usecase.aging.Config.legendary());
    private static SelectableQualityUpdater improving = new GenericQualityUpdater(byName(AGED_BRIE), simple(), com.gildedrose.core.usecase.aging.Config.improving());

    private static SelectableQualityUpdater doubleDegrading = new GenericQualityUpdater(byName(CONJURED), simple(), com.gildedrose.core.usecase.aging.Config.doubleDegrading());

    public static QualityUpdater qualityUpdater(){
        return new QualityUpdaterSelector(standard, asList(improving, legendary, backStagePassesQualityUpdater, doubleDegrading));
    }
}
