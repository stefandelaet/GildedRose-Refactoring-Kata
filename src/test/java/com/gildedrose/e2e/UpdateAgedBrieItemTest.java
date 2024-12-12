package com.gildedrose.e2e;

import com.gildedrose.Item;
import com.gildedrose.categorizeditems.AgedBrieItem;
import com.gildedrose.categorizeditems.CategorizedItem;
import com.gildedrose.categorizeditems.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateAgedBrieItemTest extends UpdateNormalItemTest {



    @Override
    @Test
    public void testNormalQuality() {
        Item item =  setupAppWithItem(10,10);
        assertEquals(createExpected( 9, 11), item);
    }

    @Test
    public void qualityDecreasesFasterAfterSellInDateExpiredZero() {
        Item item =  setupAppWithItem(0,10);
        assertEquals(createExpected( -1, 11), item);
    }

    @Test
    public void sellInDateDecreases_butQualityCannotBeNegative() {
        Item item =  setupAppWithItem(0,50);
        assertEquals(createExpected( -1, 50), item);
    }


    @Test
    public void qualityDecreasesFasterAfterSellInDateExpired() {
        Item item =  setupAppWithItem(-1,2);
        assertEquals(createExpected( -2, 3), item);
    }


    @Override
    protected Item createExpected(int sellIn, int quality){
        return new AgedBrieItem(getName(), sellIn, quality);
    }

    @Override
    protected String getName(){
        return Category.AGEDBRIE.getNameId();
    }

}
