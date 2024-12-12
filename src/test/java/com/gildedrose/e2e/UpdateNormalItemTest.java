package com.gildedrose.e2e;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import com.gildedrose.categorizeditems.NormalItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateNormalItemTest extends AbstractUpdateItemTest{

    protected String getName(){
        return "foo";
    }
    @Override
    protected Item createExpected(int sellIn, int quality){
        return new NormalItem(getName(), sellIn, quality);
    }


    @Test
    public void testNormalQuality() {
        Item item =  runAppWithOneUpdateForItem(10,10);
        assertEquals(createExpected( 9, 9), item);
    }

    @Test
    public void sellInDateDecreases_butQualityCannotBeNegative() {
        Item item =  runAppWithOneUpdateForItem(0,0);
        assertEquals(createExpected( -1, 0), item);
    }

    @Test
    public void qualityDecreasesFasterAfterSellInDateExpiredZero() {
        Item item =  runAppWithOneUpdateForItem(0,10);
        assertEquals(createExpected( -1, 8), item);
    }
    @Test
    public void qualityDecreasesFasterAfterSellInDateExpired() {
        Item item =  runAppWithOneUpdateForItem(-1,10);
        assertEquals(createExpected( -2, 8), item);
    }
}
