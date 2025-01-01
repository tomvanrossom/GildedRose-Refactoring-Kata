package com.gildedrose;

import com.gildedrose.core.usecase.qualityupdater.QualityUpdater;

public class Config {
    public static QualityUpdater qualityUpdater(){
        return com.gildedrose.core.usecase.qualityupdater.Config.qualityUpdater();
    }
}
