package com.gildedrose.e2e;

import com.gildedrose.Item;
import com.gildedrose.categorizeditems.Category;
import com.gildedrose.categorizeditems.ConjuredItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateConjuredItemTest extends AbstractUpdateItemTest {



    @Test
    public void testNormalQuality() {
        Item item =  runAppWithOneUpdateForItem(10,10);
        assertEquals(createExpected( 9, 8), item);
    }

    @Test
    public void qualityDecreasesFasterAfterSellInDateExpiredZero() {
        Item item =  runAppWithOneUpdateForItem(0,10);
        assertEquals(createExpected( -1, 6), item);
    }


    @Test
    public void qualityDecreasesFasterAfterSellInDateExpired() {
        Item item =  runAppWithOneUpdateForItem(-1,10);
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
