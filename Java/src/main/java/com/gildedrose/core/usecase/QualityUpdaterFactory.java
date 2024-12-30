package com.gildedrose.core.usecase;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class QualityUpdaterFactory {

    private static List<SelectableQualityUpdater> selectables = Arrays.asList(new OldQualityUpdater(), new LegendaryQualityUpdater());
    public static QualityUpdater create(){
        return new QualityUpdaterSelector(new StandardQualityUpdater(), selectables);
    }
}
