package com.gildedrose.e2e;

import com.gildedrose.Item;
import com.gildedrose.categorizeditems.BackstagePassItem;
import com.gildedrose.categorizeditems.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateBackstagePassItemTest extends AbstractUpdateItemTest {



    @Test
    public void testNormalQuality() {
        Item item =  runAppWithOneUpdateForItem(30,10);
        assertEquals(createExpected( 29, 11), item);
    }


    @Test
    public void testTenDaysQuality() {
        Item item =  runAppWithOneUpdateForItem(10,10);
        assertEquals(createExpected( 9, 12), item);
    }

    @Test
    public void testNineDaysQuality() {
        Item item =  runAppWithOneUpdateForItem(9,10);
        assertEquals(createExpected( 8, 12), item);
    }

    @Test
    public void testFiveDaysQuality() {
        Item item =  runAppWithOneUpdateForItem(5,10);
        assertEquals(createExpected( 4, 13), item);
    }

    @Test
    public void testTwoDaysQuality() {
        Item item =  runAppWithOneUpdateForItem(2,10);
        assertEquals(createExpected( 1, 13), item);
    }

    @Test
    public void testLastDayQuality() {
        Item item =  runAppWithOneUpdateForItem(1,10);
        assertEquals(createExpected( 0, 13), item);
    }

    @Test
    public void qualityDecreasesFasterAfterSellInDateExpiredZero() {
        Item item =  runAppWithOneUpdateForItem(0,10);
        assertEquals(createExpected( -1, 0), item);
    }


    @Test
    public void qualityDecreasesFasterAfterSellInDateExpired() {
        Item item =  runAppWithOneUpdateForItem(-1,10);
        assertEquals(createExpected( -2, 0), item);
    }


    @Override
    protected Item createExpected(int sellIn, int quality){
        return new BackstagePassItem(getName(), sellIn, quality);
    }

    @Override
    protected String getName(){
        return Category.BACKSTAGEPASS.getNameId();
    }

}
