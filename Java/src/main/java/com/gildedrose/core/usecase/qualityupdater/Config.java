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

    private static QualityUpdater standard = new AgingQualityUpdater(all(), simple(), singleDegrading());
    private static SelectableQualityUpdater backStagePassesQualityUpdater = new AgingQualityUpdater(byName(BACKSTAGE_PASSES), simple(), backstagePasses());
    static SelectableQualityUpdater legendary = new AgingQualityUpdater(byName(SULFURAS), fixed(), com.gildedrose.core.usecase.aging.Config.legendary());
    private static SelectableQualityUpdater improving = new AgingQualityUpdater(byName(AGED_BRIE), simple(), com.gildedrose.core.usecase.aging.Config.improving());

    private static SelectableQualityUpdater doubleDegrading = new AgingQualityUpdater(byName(CONJURED), simple(), com.gildedrose.core.usecase.aging.Config.doubleDegrading());

    public static QualityUpdater qualityUpdater(){
        return new QualityUpdaterSelector(standard, asList(improving, legendary, backStagePassesQualityUpdater, doubleDegrading));
    }
}
