package com.gildedrose.core.usecase;

public class QualityUpdaterFactory {
    public static QualityUpdater create(){
        return new QualityUpdaterSelector(new OldQualityUpdater(), new StandardQualityUpdater(), new LegendaryQualityUpdater());
    }
}
