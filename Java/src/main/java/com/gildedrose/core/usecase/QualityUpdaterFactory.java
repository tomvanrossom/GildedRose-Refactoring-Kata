package com.gildedrose.core.usecase;

import com.gildedrose.core.domain.SpecialNames;
import com.gildedrose.core.usecase.aging.AgingFunctions;

import java.util.Arrays;

public class QualityUpdaterFactory {

    private static QualityUpdater standard = new AgingQualityUpdater(new SelectsAll(), AgingFunctions.standard());
    private static SelectableQualityUpdater old = new OldQualityUpdater();
    private static SelectableQualityUpdater legendary = new LegendaryQualityUpdater();
    public static QualityUpdater create(){
        return new QualityUpdaterSelector(standard, Arrays.asList(legendary, old));
    }
}
