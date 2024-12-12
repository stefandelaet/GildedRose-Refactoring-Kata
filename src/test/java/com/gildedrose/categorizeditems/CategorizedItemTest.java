package com.gildedrose.categorizeditems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategorizedItemTest {


    @Test
    public void testInvalidCtrValuesCorrection(){
        CategorizedItem item = new NormalItem(null,-45, -6);
        Assertions.assertEquals(new NormalItem("",-45, 0),  item);
        item = new NormalItem("vsmpovmqwomewt908435tr2",800, 75);
        Assertions.assertEquals(new NormalItem("vsmpovmqwomewt908435tr2",800, 50),  item);
        item = new LegendaryItem(Category.LEGENDARY.getNameId(),65,33);
        Assertions.assertEquals(new LegendaryItem(Category.LEGENDARY.getNameId(), Integer.MAX_VALUE, LegendaryItem.LEGENDARYQUALITY),  item);
    }

    @Test
    public void testCategoryAssignment(){
        CategorizedItem item = new NormalItem("x",1, 1);
        Assertions.assertEquals( Category.NORMAL, item.getCategory());
        item = new AgedBrieItem("x ",2,2);
        Assertions.assertEquals(Category.AGEDBRIE, item.getCategory());
        item = new BackstagePassItem("x ",2,2);
        Assertions.assertEquals(Category.BACKSTAGEPASS, item.getCategory());
        item = new ConjuredItem("x ",2,2);
        Assertions.assertEquals(Category.CONJURED, item.getCategory());
        item = new LegendaryItem("x ",2,2);
        Assertions.assertEquals(Category.LEGENDARY, item.getCategory());
    }

    @Test
    public void testUpdateSellin(){
        CategorizedItem item = new CategorizedItem("x", 10, 10) { // test abstract class implementation
            @Override
            public void updateQualityImpl() {}
        };
        int expectedSellin = item.sellIn - 1;
        item.updateSellIn();
        Assertions.assertEquals(expectedSellin, item.sellIn);
    }

    //Quality tests of Categorized items are covered in com.gildedrose.e2e packaqe
}
