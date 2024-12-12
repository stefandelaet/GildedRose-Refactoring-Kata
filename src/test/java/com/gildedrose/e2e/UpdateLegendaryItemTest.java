package com.gildedrose.e2e;

import com.gildedrose.Item;
import com.gildedrose.categorizeditems.Category;
import com.gildedrose.categorizeditems.LegendaryItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateLegendaryItemTest extends AbstractUpdateItemTest {



    @Test
    public void testNormalQuality() {
        Item item =  runAppWithOneUpdateForItem(Integer.MAX_VALUE,80);
        assertEquals(createExpected( Integer.MAX_VALUE, 80), item);
    }

    @Test
    public void testInitCorrection() {
        Item item =  runAppWithOneUpdateForItem(1,32);
        assertEquals(createExpected( Integer.MAX_VALUE, 80), item);
    }

    @Test
    public void qualityDecreasesFasterAfterSellInDateExpiredZero() {
        Item item =  runAppWithOneUpdateForItem(0,10);
        assertEquals(createExpected( Integer.MAX_VALUE, 80), item);
    }


    @Test
    public void qualityDecreasesFasterAfterSellInDateExpired() {
        Item item =  runAppWithOneUpdateForItem(-1,10);
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
