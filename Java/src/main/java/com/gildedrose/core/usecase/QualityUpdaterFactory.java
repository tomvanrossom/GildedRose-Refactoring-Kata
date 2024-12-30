package com.gildedrose.core.usecase;

import com.gildedrose.core.domain.SpecialNames;
import com.gildedrose.core.usecase.aging.AgingFunctions;
import com.gildedrose.core.usecase.aging.BackstagePassAging;

import java.util.Arrays;

public class QualityUpdaterFactory {

    private static QualityUpdater standard = new AgingQualityUpdater(new SelectsAll(), AgingFunctions.standard());
    private static SelectableQualityUpdater backStagePassesQualityUpdater = new AgingQualityUpdater(new SelectableByName(SpecialNames.BACKSTAGE_PASSES), new BackstagePassAging());
    private static SelectableQualityUpdater legendary = new LegendaryQualityUpdater();
    private static SelectableQualityUpdater improving = new AgingQualityUpdater(new SelectableByName(SpecialNames.AGED_BRIE), AgingFunctions.improving());

    public static QualityUpdater create(){
        return new QualityUpdaterSelector(standard, Arrays.asList(improving, legendary, backStagePassesQualityUpdater));
    }
}
