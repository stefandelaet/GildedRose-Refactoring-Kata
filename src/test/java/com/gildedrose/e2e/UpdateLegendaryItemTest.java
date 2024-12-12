package com.gildedrose.e2e;

import com.gildedrose.Item;
import com.gildedrose.categorizeditems.CategorizedItem;
import com.gildedrose.categorizeditems.Category;
import com.gildedrose.categorizeditems.LegendaryItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateLegendaryItemTest extends UpdateNormalItemTest {



    @Override
    @Test
    public void testNormalQuality() {
        Item item =  setupAppWithItem(Integer.MAX_VALUE,80);
        assertEquals(createExpected( Integer.MAX_VALUE, 80), item);
    }

    @Test
    public void testInitCorrection() {
        Item item =  setupAppWithItem(1,32);
        assertEquals(createExpected( Integer.MAX_VALUE, 80), item);
    }

    @Test
    public void qualityDecreasesFasterAfterSellInDateExpiredZero() {
        Item item =  setupAppWithItem(0,10);
        assertEquals(createExpected( Integer.MAX_VALUE, 80), item);
    }


    @Test
    public void qualityDecreasesFasterAfterSellInDateExpired() {
        Item item =  setupAppWithItem(-1,10);
        assertEquals(createExpected( Integer.MAX_VALUE, 80), item);
    }


    @Override
    protected Item createExpected(int sellIn, int quality){
        return new LegendaryItem(getName(), sellIn, quality);
    }

    @Override
    protected String getName(){
        return Category.LEGENDARY.getNameId();
    }

}
