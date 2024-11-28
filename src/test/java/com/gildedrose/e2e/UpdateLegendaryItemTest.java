package com.gildedrose.e2e;

import com.gildedrose.categorizeditems.CategorizedItem;
import com.gildedrose.categorizeditems.Category;
import com.gildedrose.categorizeditems.LegendaryItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateLegendaryItemTest extends UpdateNormalItemTest {



    @Override
    @Test
    public void testNormalQuality() {
        CategorizedItem item =setupItem(Integer.MAX_VALUE,80);
        assertEquals(createExpected( Integer.MAX_VALUE, 80), item);
    }

    @Test
    public void testInitCorrection() {
        CategorizedItem item =setupItem(1,32);
        assertEquals(createExpected( Integer.MAX_VALUE, 80), item);
    }

    @Test
    public void qualityDecreasesFasterAfterSellInDateExpiredZero() {
        CategorizedItem item =setupItem(0,10);
        assertEquals(createExpected( Integer.MAX_VALUE, 80), item);
    }


    @Test
    public void qualityDecreasesFasterAfterSellInDateExpired() {
        CategorizedItem item =setupItem(-1,10);
        assertEquals(createExpected( Integer.MAX_VALUE, 80), item);
    }


    @Override
    protected CategorizedItem createExpected(int sellIn, int quality){
        return new LegendaryItem(getName(), sellIn, quality);
    }

    @Override
    protected String getName(){
        return Category.LEGENDARY.getNameId();
    }

}
