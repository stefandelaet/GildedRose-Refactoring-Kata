package com.gildedrose.e2e;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import com.gildedrose.categorizeditems.CategorizedItem;
import com.gildedrose.categorizeditems.NormalItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateNormalItemTest {

    protected String getName(){
        return "foo";
    }

    @Test
    public void testNormalQuality() {
        CategorizedItem item = setupAppWithItem(10,10);
        assertEquals(createExpected( 9, 9), item);
    }

    @Test
    public void sellInDateDecreases_butQualityCannotBeNegative() {
        CategorizedItem item = setupAppWithItem(0,0);
        assertEquals(createExpected( -1, 0), item);
    }

    @Test
    public void qualityDecreasesFasterAfterSellInDateExpiredZero() {
        CategorizedItem item = setupAppWithItem(0,10);
        assertEquals(createExpected( -1, 8), item);
    }
    @Test
    public void qualityDecreasesFasterAfterSellInDateExpired() {
        CategorizedItem item = setupAppWithItem(-1,10);
        assertEquals(createExpected( -2, 8), item);
    }

    protected CategorizedItem createExpected(int sellIn, int quality){
        return new NormalItem(getName(), sellIn, quality);
    }

    protected CategorizedItem setupAppWithItem(int sellIn, int quality){
        GildedRose app = new GildedRose(new Item(getName(), sellIn, quality));
        app.updateQuality(); // use original entrypoint
        return app.getItems().getFirst();
    }


}
