package com.gildedrose.core.usecase.qualityupdater;

import com.gildedrose.core.usecase.aging.AgingFunctions;

import java.util.Arrays;

import static com.gildedrose.core.domain.SpecialNames.*;
import static com.gildedrose.core.usecase.aging.AgingFunctions.backstagePasses;
import static com.gildedrose.core.usecase.aging.AgingFunctions.singleDegrading;
import static com.gildedrose.core.usecase.selectable.Selectables.all;
import static com.gildedrose.core.usecase.selectable.Selectables.byName;

public class QualityUpdaterFactory {

    private static QualityUpdater standard = new AgingQualityUpdater(all(), singleDegrading());
    private static SelectableQualityUpdater backStagePassesQualityUpdater = new AgingQualityUpdater(byName(BACKSTAGE_PASSES), backstagePasses());
    private static SelectableQualityUpdater legendary = new LegendaryQualityUpdater();
    private static SelectableQualityUpdater improving = new AgingQualityUpdater(byName(AGED_BRIE), AgingFunctions.improving());

    private static SelectableQualityUpdater doubleDegrading = new AgingQualityUpdater(byName(CONJURED), AgingFunctions.doubleDegrading());

    public static QualityUpdater create(){
        return new QualityUpdaterSelector(standard, Arrays.asList(improving, legendary, backStagePassesQualityUpdater, doubleDegrading));
    }
}
