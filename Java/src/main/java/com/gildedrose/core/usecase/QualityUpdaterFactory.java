package com.gildedrose.core.usecase;

import java.util.Arrays;
import java.util.List;

public class QualityUpdaterFactory {

    private static QualityUpdater standard = new StandardQualityUpdater(1, 50);
    private static SelectableQualityUpdater old = new OldQualityUpdater();
    private static SelectableQualityUpdater legendary = new LegendaryQualityUpdater();

    public static QualityUpdater create(){
        return new QualityUpdaterSelector(standard, Arrays.asList(old, legendary));
    }
}
