package com.gildedrose.e2e;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import com.gildedrose.categorizeditems.CategorizedItem;
import com.gildedrose.categorizeditems.NormalItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateNormalItemNewEntrypointTest {

    protected String getName(){
        return "foo";
    }

    @Test
    public void testNormalQuality() {
        CategorizedItem item =setupItem(10,10);
        assertEquals(createExpected( 9, 9), item);
    }

    @Test
    public void sellInDateDecreases_butQualityCannotBeNegative() {
        CategorizedItem item =setupItem(0,0);
        assertEquals(createExpected( -1, 0), item);
    }

    @Test
    public void qualityDecreasesFasterAfterSellInDateExpiredZero() {
        CategorizedItem item =setupItem(0,10);
        assertEquals(createExpected( -1, 8), item);
    }
    @Test
    public void qualityDecreasesFasterAfterSellInDateExpired() {
        CategorizedItem item = setupItem(-1,10);
        assertEquals(createExpected( -2, 8), item);
    }

    protected CategorizedItem createExpected(int sellIn, int quality){
        return new NormalItem(getName(), sellIn, quality);
    }

    protected CategorizedItem setupItem(int sellIn, int quality){
        GildedRose app = new GildedRose(new Item(getName(), sellIn, quality));
        app.recalculateItems(); // use new entrypoint
        return app.getItems().getFirst();
    }


}
