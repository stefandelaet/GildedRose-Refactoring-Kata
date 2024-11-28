package com.gildedrose.e2e;

import com.gildedrose.categorizeditems.BackstagePassItem;
import com.gildedrose.categorizeditems.CategorizedItem;
import com.gildedrose.categorizeditems.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateBackstagePassItemTest extends UpdateNormalItemTest {



    @Override
    @Test
    public void testNormalQuality() {
        CategorizedItem item =setupItem(30,10);
        assertEquals(createExpected( 29, 11), item);
    }


    @Test
    public void testTenDaysQuality() {
        CategorizedItem item =setupItem(10,10);
        assertEquals(createExpected( 9, 12), item);
    }

    @Test
    public void testNineDaysQuality() {
        CategorizedItem item =setupItem(9,10);
        assertEquals(createExpected( 8, 12), item);
    }

    @Test
    public void testFiveDaysQuality() {
        CategorizedItem item =setupItem(5,10);
        assertEquals(createExpected( 4, 13), item);
    }

    @Test
    public void testTwoDaysQuality() {
        CategorizedItem item =setupItem(2,10);
        assertEquals(createExpected( 1, 13), item);
    }

    @Test
    public void testLastDayQuality() {
        CategorizedItem item =setupItem(1,10);
        assertEquals(createExpected( 0, 13), item);
    }

    @Test
    public void qualityDecreasesFasterAfterSellInDateExpiredZero() {
        CategorizedItem item =setupItem(0,10);
        assertEquals(createExpected( -1, 0), item);
    }


    @Test
    public void qualityDecreasesFasterAfterSellInDateExpired() {
        CategorizedItem item =setupItem(-1,10);
        assertEquals(createExpected( -2, 0), item);
    }


    @Override
    protected CategorizedItem createExpected(int sellIn, int quality){
        return new BackstagePassItem(getName(), sellIn, quality);
    }

    @Override
    protected String getName(){
        return Category.BACKSTAGEPASS.getNameId();
    }

}
