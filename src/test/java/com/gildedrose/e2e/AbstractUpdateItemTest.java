package com.gildedrose.e2e;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;

public abstract class AbstractUpdateItemTest {

    protected abstract String getName();

    protected abstract Item createExpected(int sellIn, int quality);

    protected Item runAppWithOneUpdateForItem(int sellIn, int quality){
        GildedRose app = new GildedRose(new Item(getName(), sellIn, quality));
        app.updateQuality(); // use original entrypoint
        return app.getItems().getFirst();
    }

}
