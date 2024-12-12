package com.gildedrose.e2e;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateNormalItemNewEntrypointTest extends UpdateNormalItemTest {

    @Override
    protected Item setupAppWithItem(int sellIn, int quality){
        GildedRose app = new GildedRose(new Item(getName(), sellIn, quality));
        app.recalculateItems(); // use new entrypoint
        return app.getItems().getFirst();
    }


}
