package com.gildedrose.e2e;

import com.gildedrose.Item;
import com.gildedrose.categorizeditems.CategorizedItem;
import com.gildedrose.categorizeditems.Category;
import com.gildedrose.categorizeditems.ConjuredItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateConjuredItemTest extends UpdateNormalItemTest {



    @Override
    @Test
    public void testNormalQuality() {
        Item item =  setupAppWithItem(10,10);
        assertEquals(createExpected( 9, 8), item);
    }

    @Test
    public void qualityDecreasesFasterAfterSellInDateExpiredZero() {
        Item item =  setupAppWithItem(0,10);
        assertEquals(createExpected( -1, 6), item);
    }


    @Test
    public void qualityDecreasesFasterAfterSellInDateExpired() {
        Item item =  setupAppWithItem(-1,10);
        assertEquals(createExpected( -2, 6), item);
    }


    @Override
    protected Item createExpected(int sellIn, int quality){
        return new ConjuredItem(getName(), sellIn, quality);
    }

    @Override
    protected String getName(){
        return Category.CONJURED.getNameId();
    }

}
